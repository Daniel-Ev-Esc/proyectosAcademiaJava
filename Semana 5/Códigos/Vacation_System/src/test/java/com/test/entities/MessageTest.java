package com.test.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import com.em.entities.*;

import org.junit.jupiter.api.Test;

class MessageTest {

	@Test
	void CustomMessageTest() {
		CustomMessage cm = new CustomMessage("id1","Hello World", false, new Date(2024, 9, 1));
		
		assertEquals(cm.getMessageId(), "id1");
		assertEquals(cm.getMessage(), "Hello World");
		assertEquals(cm.getDismissed(), false);
		assertEquals(cm.getMessageDate(), new Date(2024, 9, 1));
	}

}
