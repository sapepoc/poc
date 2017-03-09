package org.sapient.fetcher.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FileDetailsLogger implements Processor
{
	private static final Logger LOGGER = LoggerFactory.getLogger(FileDetailsLogger.class);
	
	@Override
	public void process(Exchange exchange) throws Exception 
	{
		Message message = exchange.getIn();
		
		LOGGER.info("Fetched entity details:: entityName={}, entitySise={}",
				message.getHeader("CamelFileName"), message.getHeader("CamelFileLength"));
	}
}
