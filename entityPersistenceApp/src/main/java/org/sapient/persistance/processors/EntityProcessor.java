package org.sapient.persistance.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.sapient.entites.transaction.Transactions;
import org.sapient.entites.transaction.Transactions.Transaction;
import org.sapient.entites.user.Users;
import org.sapient.persistance.entities.Tranasaction;
import org.sapient.persistance.entities.User;
import org.sapient.persistance.services.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityProcessor implements Processor
{
	private static final Logger LOGGER = LoggerFactory.getLogger(EntityProcessor.class);
	
	@Autowired
	private GenericService<User,Long> userService;
	
	@Autowired
	private GenericService<Tranasaction, Long> tranasactionService;
	
	@Override
	public void process(Exchange exchange) throws Exception 
	{
		LOGGER.info("Entity recevied, enityType={}", exchange.getIn().getBody());
		if(exchange.getIn().getBody() instanceof Users)
		{
			Users users = (Users)exchange.getIn().getBody();
			for (org.sapient.entites.user.Users.User user : users.getUser()) 
	    	{
	    		userService.create(new User(user.getFirstName(), user.getLastName()));
	    	}
		}
		else if(exchange.getIn().getBody() instanceof Transactions)
		{
			Transactions transactions = (Transactions)exchange.getIn().getBody();
			for (Transaction transaction : transactions.getTransaction())
			{
				tranasactionService.create(new Tranasaction(transaction.getMessage(), transaction.getStatus()));
			}
		}
	}

}
