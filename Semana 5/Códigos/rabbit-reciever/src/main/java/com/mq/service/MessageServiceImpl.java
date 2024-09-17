package com.mq.service;

import org.springframework.stereotype.Service;

import com.mq.reciever.CustomMessage;
import com.mq.reciever.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	MessageRepository mr;
	
	public MessageServiceImpl(MessageRepository mr) {
		this.mr = mr;
	}

	@Override
	public CustomMessage save(CustomMessage cm) {
		return mr.save(cm);
	}
}
