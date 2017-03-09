package org.sapient.fetcher.utils;

import java.io.File;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
}  