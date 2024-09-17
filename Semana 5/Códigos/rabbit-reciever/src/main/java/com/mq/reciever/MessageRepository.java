package com.mq.reciever;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<CustomMessage, String>{

}