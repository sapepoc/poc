package org.sapient.persistance.routes;

import org.apache.camel.builder.RouteBuilder;
import org.sapient.persistance.processors.EntityProcessor;
import org.springframework.beans.factory.annotation.Autowired;

//@Component
//Disable: not use
public class EntityRouteBuilder extends RouteBuilder 
{	
	@Autowired
	private EntityProcessor entityProcessor;
	
	@Override
	public void configure() throws Exception 
	{
		from("{{inbound.endpoint}}").process(entityProcessor);
	}
}