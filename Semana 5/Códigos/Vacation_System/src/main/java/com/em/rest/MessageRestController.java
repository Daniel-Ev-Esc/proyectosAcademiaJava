package com.em.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.em.entities.CustomMessage;
import com.em.service.MessageService;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "http://localhost:4200")  
public class MessageRestController {
	
    private MessageService messageService;

    @Autowired
    public MessageRestController(MessageService messageService) {
		this.messageService = messageService;
	}
    
    @GetMapping("")
    public List<CustomMessage> getAll() {
        return messageService.getAll();
    }
    
    @PutMapping("/dismiss/{id}")
    public CustomMessage dismiss(@PathVariable String id) {
    	return messageService.dismiss(id);
    }


}
