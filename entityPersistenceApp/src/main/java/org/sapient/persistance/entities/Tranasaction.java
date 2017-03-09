package org.sapient.persistance.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="E_TBL_TRANASACTION")
public class Tranasaction implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String message;
	private String status;

	public Tranasaction(){}
	public Tranasaction(String message, String status)
	{
		this.message = message;
		this.status = status;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public String getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "Tranasaction [id=" + id + ", message=" + message + ", status="
				+ status + "]";
	}
}
