package com.em.service;

import java.util.List;

import com.em.entities.CustomMessage;

public interface MessageService {

	List<CustomMessage> getAll();
	
	CustomMessage dismiss(String id);

}
