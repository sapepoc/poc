package org.sapient.fetcher.jms.publisher;

import org.sapient.dto.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;

//@Component
//Disabled: Not used
public class MessageSender 
{
	private final JmsTemplate jmsTemplate;
	@Value("${outbound.endpoint}")
	private String destination;
	@Autowired
	public MessageSender(JmsTemplate jmsTemplate)
	{
		this.jmsTemplate = jmsTemplate;
	}
	
	public void send(PriceEntity entity)
	{
		jmsTemplate.convertAndSend(destination, entity);
	}
}
