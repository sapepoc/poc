package org.sapient.persistance.services;

import org.sapient.persistance.entities.User;
import org.sapient.persistance.repositoires.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public class UserService implements GenericService<User, Long>
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public CrudRepository<User, Long> getRepository() 
	{
		return userRepository;
	}
}
