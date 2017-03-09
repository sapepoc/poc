package org.sapient.fetcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJms
public class EntityFetcherRunner 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(EntityFetcherRunner.class, args);
	}
}
