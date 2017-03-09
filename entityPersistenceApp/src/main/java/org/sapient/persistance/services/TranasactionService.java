package org.sapient.persistance.services;

import org.sapient.persistance.entities.Tranasaction;
import org.sapient.persistance.repositoires.TranasactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class TranasactionService implements GenericService<Tranasaction, Long>
{
	@Autowired
	private TranasactionRepository tranasactionRepository;
	
	@Override
	public CrudRepository<Tranasaction, Long> getRepository() 
	{
		return tranasactionRepository;
	}
}
