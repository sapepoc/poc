package org.sapient.paserapp.processors;

import org.sapient.entites.transaction.Transactions;
import org.springframework.stereotype.Component;

@Component(value="tranasactionEntityProcessor")
public class TranasactionEntityProcessor extends AbstractEntityProcessor<Transactions>
{
	public TranasactionEntityProcessor() 
	{
		super(Transactions.class);
	}
}
