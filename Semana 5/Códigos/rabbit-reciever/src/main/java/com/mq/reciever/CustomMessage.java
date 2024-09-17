package com.mq.reciever;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name= "messages")
public class CustomMessage {

	@Id
    private String messageId;
    private String message;
    private Boolean dismissed;
    private Date messageDate;

}
