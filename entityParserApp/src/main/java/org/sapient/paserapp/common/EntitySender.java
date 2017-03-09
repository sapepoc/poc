package org.sapient.paserapp.common;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntitySender<V> implements MessageSender<V>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(EntitySender.class);
	
	@Autowired
	private ProducerTemplate producerTemplate;

	@Override
	public void sendMessage(String endPoint, V value) 
	{
		LOGGER.info("Message sent, endPoint={}, value={}", endPoint, value);
		producerTemplate.sendBody(endPoint, value);
	}
}
