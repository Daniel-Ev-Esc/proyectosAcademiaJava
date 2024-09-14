package com.em.batch;



import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.em.entities.VacationRequest;
import com.em.enumerators.Status;
import com.em.repository.VacationRequestRepository;

import lombok.AllArgsConstructor;


@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfig {
	
	private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;
    
    private VacationRequestRepository vacationRequestRepository;
	
	@Bean
    public JpaPagingItemReader<VacationRequest> reader(EntityManagerFactory entityManagerFactory) {
        return new JpaPagingItemReaderBuilder<VacationRequest>()
                .name("vrReader")
                .entityManagerFactory(entityManagerFactory)
                .queryString("SELECT vr FROM VacationRequest vr")
                .pageSize(10)
                .build();
    }
	
	@Bean
	public ItemProcessor<VacationRequest, VacationRequest> processor(){
		return item -> {
			if(Status.ACCEPTED.equals(item.getStatus()) || Status.DECLINED.equals(item.getStatus())){
				item.setStatus(Status.COMPLETED);
			}
			
			return item;
		};
	}
	
	@Bean
	public JpaItemWriter<VacationRequest> writer(EntityManagerFactory entityManagerFactory) {
	    JpaItemWriter<VacationRequest> writer = new JpaItemWriter<>();
	    writer.setEntityManagerFactory(entityManagerFactory);
	    return writer;
	}

	@Bean
    public Job runJob() {
        return jobBuilderFactory
        		.get("importCustomers")
        		.flow(step1())
        		.end()
        		.build();

    }
	
	@Bean
    public Step step1() {
        return stepBuilderFactory.get("csv-step")
        		.<VacationRequest, VacationRequest>chunk(10)
                .reader(reader(null))
                .processor(processor())
                .writer(writer(null))
                .taskExecutor(taskExecutor())
                .build();
    }
	
	@Bean
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

}
