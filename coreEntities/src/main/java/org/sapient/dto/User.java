package org.sapient.dto;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(namespace = "http://www.example.org/user")	
public class User 
{
	private int id;
	private String name;
	public User(){}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@XmlAttribute
	public int getId() {
		return id;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}
	
}
