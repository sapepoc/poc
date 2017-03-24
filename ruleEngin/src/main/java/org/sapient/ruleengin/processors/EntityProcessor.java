package org.sapient.ruleengin.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.sapient.entites.trade.Trades;
import org.sapient.ruleengin.TradeEntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="entityProcessor")
public class EntityProcessor implements Processor
{
	private static final Logger LOGGER = LoggerFactory.getLogger(EntityProcessor.class);
	
	private TradeEntityManager tradeEntityManager;
	
	@Autowired
	public EntityProcessor(TradeEntityManager tradeEntityManager)
	{
		this.tradeEntityManager = tradeEntityManager;
	}
	
	@Override
	public void process(Exchange exchange) throws Exception 
	{
		LOGGER.info("Entity recevied, enityType={}", exchange.getIn().getBody());
		if(exchange.getIn().getBody() instanceof Trades)
		{
			Trades trades = (Trades)exchange.getIn().getBody();
			tradeEntityManager.process(trades.getTrade());
		}
	}
}
