package org.sapient.paserapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJms
public class EntityParserRunner 
{
	public static void main(String[] args) 
	{
		System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");
		SpringApplication.run(EntityParserRunner.class, args);
	}
}
