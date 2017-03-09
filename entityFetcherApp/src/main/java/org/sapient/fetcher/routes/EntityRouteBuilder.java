package org.sapient.fetcher.routes;

import org.apache.camel.builder.RouteBuilder;
import org.sapient.fetcher.processors.FileDetailsLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityRouteBuilder extends RouteBuilder 
{	
	@Autowired
	private FileDetailsLogger fileDetailsLogger;

	@Override
	public void configure() throws Exception 
	{
		from("{{inbound.endpoint}}"+"?noop=true").process(fileDetailsLogger)
		.choice()
		.when(header("CamelFileName").endsWith(".xml"))
			.to("{{outbound.endpoint}}")
		.when(header("CamelFileName").endsWith(".csv"))
			.to("{{outbound.endpoint}}")
		.otherwise()
			.to("{{outbound.endpoint}}");
	}
}