package org.sapient.paserapp.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.sapient.paserapp.common.EntitySender;
import org.sapient.paserapp.utils.XmlToObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

class AbstractEntityProcessor<T> implements Processor
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEntityProcessor.class);
	
	@Value("${outbound.endpoint}")
	private String destinationPoint;
	
	@Autowired
	private EntitySender<T> entitySender;
	private Class<T> entityType;
	
	AbstractEntityProcessor(Class<T> entityType)
	{
		this.entityType = entityType;
	}
	
	@Override
	public void process(Exchange exchange) throws Exception 
	{
		LOGGER.info("Received XML entity, entityName={}", exchange.getIn().getHeader("CamelFileName"));
		String xmlEntity = exchange.getIn().getBody(String.class);
		if(xmlEntity != null)
		{
			T entityInstance = XmlToObject.loadEntityFromString(xmlEntity, entityType);
			entitySender.sendMessage(destinationPoint, entityInstance);
		}
	}
}
