package org.sapient.paserapp.processors;

import org.sapient.entites.user.Users;
import org.springframework.stereotype.Component;

/**
 * 
 * @author OM SINGH
 */
@Component
public class UserEntityProcessor extends AbstractEntityProcessor<Users>
{
	public UserEntityProcessor() 
	{
		super(Users.class);
	}
}
