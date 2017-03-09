package org.sapient.fetcher.utils;

import java.io.File;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.sapient.entites.transaction.Transactions;
import org.sapient.entites.transaction.Transactions.Transaction;
import org.sapient.entites.user.Users;

public class XmlToObject 
{  
	@SuppressWarnings("unchecked")
	public static <T> T loadEntityFromString(String content, Class<T> entityType)
	{
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(entityType);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			StringReader reader = new StringReader(content);
			return (T)unmarshaller.unmarshal(reader); 
		} 
		catch (JAXBException e)
		{  
			throw new RuntimeException("Problem in xml load  path="+ content, e) ; 
		} 
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T loadEntity(String entityFilePath, Class<T> entityType)
	{
		File file = new File(entityFilePath); 
		try
		{
			JAXBContext jaxbContext = JAXBContext.newInstance(entityType); 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
    		return (T)jaxbUnmarshaller.unmarshal(file); 
		} 
		catch (JAXBException e)
		{  
			throw new RuntimeException("Problem in xml load  path="+ entityFilePath, e) ; 
		} 
	}
	
    public static void main(String[] args) 
    {  
    	Users users= loadEntity("./indir/users.xml", Users.class);  
    	for (org.sapient.entites.user.Users.User user : users.getUser()) 
    	{
    		System.out.println("firstName="+ user.getFirstName() + " , lastName="+ user.getLastName());  
    	}
    	
    	Transactions transactions = loadEntity("./indir/transactions.xml", Transactions.class);
    	for (Transaction transaction : transactions.getTransaction())
    	{
    		System.out.println("Id="+ transaction.getId() + " , status="+ transaction.getStatus()
    				+ " ,message="+ transaction.getMessage());  
		}
    }  
}  