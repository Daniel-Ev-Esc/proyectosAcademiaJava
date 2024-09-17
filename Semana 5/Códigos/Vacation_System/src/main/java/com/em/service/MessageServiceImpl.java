package com.em.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.em.entities.CustomMessage;
import com.em.entities.HREmployee;
import com.em.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	MessageRepository mr;
	
	@Autowired
	public MessageServiceImpl(MessageRepository mr) {
		super();
		this.mr = mr;
	}
	
	@Override
	public List<CustomMessage> getAll() {
		return mr.findAll();
	}
	
	@Override
	public CustomMessage dismiss(String id) {
		Optional<CustomMessage> result = mr.findById(id);
		
		CustomMessage theMessage = null;
				
		if(result.isPresent()) {
			theMessage = result.get();
		}
		else {
			throw new RuntimeException("Did not find message" + id);
		}
		
		theMessage.setDismissed(true);
		
		mr.save(theMessage);
		
		return theMessage;
	}

}
