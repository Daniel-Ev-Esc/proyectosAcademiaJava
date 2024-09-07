package com.curso.v0.Batch.config;

import java.util.function.Supplier;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.curso.v0.Batch.dao.TimecardRepository;
import com.curso.v0.Batch.entity.Timecard;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

	private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private TimecardRepository timecardRepository;
    
    
    @Bean
    public FlatFileItemReader<Timecard> reader() {
    	FlatFileItemReader<Timecard> itemReader = new FlatFileItemReader<Timecard>();
    	itemReader.setResource(new FileSystemResource("src/main/resources/TimecardData.csv"));
    	itemReader.setName("csvReader");
    	itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }
    
    private LineMapper<Timecard> lineMapper() {
        DefaultLineMapper<Timecard> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "name", "department", "entryTime", "exitTime", "lunchTime");
        
        BeanWrapperFieldSetMapper<Timecard> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Timecard.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }
    
    @Bean
    public Step step1() {
    	
    	Supplier<RepositoryItemWriter<Timecard>> supplier = () -> {
			RepositoryItemWriter<Timecard> writer = new RepositoryItemWriter<>();
	        writer.setRepository(timecardRepository);
	        writer.setMethodName("save");
	        return writer;
       	};
    	
    	return stepBuilderFactory.get("csv-step")
        		.<Timecard, Timecard>chunk(10)
                .reader(reader())
                .processor((ItemProcessor<Timecard, Timecard>) client -> {
                	if(client.getDepartment().equals("IT"))
                        return client;
                    return null;
                })
                .writer(supplier.get())
                .taskExecutor(taskExecutor())
                .build();
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
    public TaskExecutor taskExecutor() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }
}
