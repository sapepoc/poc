package org.sapient.paserapp.routes;

import org.apache.camel.builder.RouteBuilder;
import org.sapient.paserapp.processors.TranasactionEntityProcessor;
import org.sapient.paserapp.processors.UserEntityProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityRouteBuilder extends RouteBuilder 
{	
	@Autowired
	private TranasactionEntityProcessor tranasactionEntityProcessor;
	
	@Autowired
	private UserEntityProcessor userEntityProcessor;

	@Override
	public void configure() throws Exception 
	{
		from("{{inbound.endpoint}}")
		.choice()
		.when(header("CamelFileName").startsWith("users"))
			.process(userEntityProcessor)
		.when(header("CamelFileName").startsWith("transactions"))
			.process(tranasactionEntityProcessor);
	}
}