package com.mq.reciever;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.mq.service.MessageService;

@Component
@ComponentScan(basePackages = {"com.mq.service", "com.mq.reciever"})
public class MessageListener {
	
	MessageService ms;
	
	@Autowired
    public MessageListener(MessageService ms) {
		this.ms = ms;
	}

	@RabbitListener(queues = MQConfig.QUEUE)
    public void listener(CustomMessage message) {
        ms.save(message);
    }

}
