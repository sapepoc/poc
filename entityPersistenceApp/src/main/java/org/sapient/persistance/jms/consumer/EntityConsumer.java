package org.sapient.persistance.jms.consumer;

import org.sapient.entites.user.Users;
import org.sapient.persistance.entities.User;
import org.sapient.persistance.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;

//@Component
//Disable the JMS
public class EntityConsumer 
{
	@Autowired
	private GenericService<User,Long> userService;
	
    @JmsListener(destination = "${inbound.entity.instance.user.endpoint}")
    public void processUserEntity(Users users)
    {
    	for (org.sapient.entites.user.Users.User user : users.getUser()) 
    	{
    		System.out.println("firstName="+ user.getFirstName() + " , lastName="+ user.getLastName());
    		userService.create(new User(user.getFirstName(), user.getLastName()));
    	}
    }
}
