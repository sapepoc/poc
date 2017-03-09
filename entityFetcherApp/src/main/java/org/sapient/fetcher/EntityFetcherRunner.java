package org.sapient.fetcher;

import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@ImportResource({ "classpath:application-context.xml" })
public class EntityFetcherRunner 
{
	public static void main(String[] args) throws InterruptedException 
	{
		ConfigurableApplicationContext context = SpringApplication.run(EntityFetcherRunner.class, args);
		CamelSpringBootApplicationController appController =
				context.getBean(CamelSpringBootApplicationController.class);
		
		//Runs the application and blocks the main thread and shutdown Camel graceful when the JVM is stopping.
		appController.run();
	}
}
