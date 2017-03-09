package org.sapient.paserapp.jms.publisher;

import org.sapient.dto.Entity;
import org.sapient.dto.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;

//@Component
//Disable: Not used
public class Sender 
{
	private final JmsTemplate jmsTemplate;
	@Value("${outbound.endpoint}")
	private String destination;
	
	@Autowired
	public Sender(JmsTemplate jmsTemplate)
	{
		this.jmsTemplate = jmsTemplate;
	}
	
	public void send(Payload<String, Entity<String>> payload)
	{
		jmsTemplate.convertAndSend(destination, payload);
	}
}
