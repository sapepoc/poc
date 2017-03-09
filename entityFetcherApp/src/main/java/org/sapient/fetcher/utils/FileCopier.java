package org.sapient.fetcher.utils;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopier 
{
	private CamelContext camelContext;
	
	private FileCopier(CamelContext camelContext)
	{
		this.camelContext = camelContext;
	}
	
	public void copy(final String pathFrom, final String  pathTo)
	{
		   try
		   {
			   camelContext.addRoutes(
					   new RouteBuilder()
					   {
						   @Override
						   public void configure() throws Exception
						   {
							   from("file:"+pathFrom+"?noop=true").to("file:"+pathTo);
						   }
					   });
			   camelContext.start();
			   Thread.sleep(5000);
			   camelContext.stop();
		   }
		   catch (Exception camelException)
		   {
		  
		   }
	}
	
	public static void main(String[] args) 
	{
		new FileCopier(new DefaultCamelContext()).copy(".//indir", ".//outdir");
	}
}
