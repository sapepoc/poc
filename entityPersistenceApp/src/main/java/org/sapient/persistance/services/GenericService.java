package org.sapient.persistance.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenericService<E,ID extends Serializable>
{
	default List<E> readAll()
	{
		return (List<E>) getRepository().findAll();
	}
	
	default E readById(ID id)
	{
		return getRepository().findOne(id);
	}
	
	default E create(E entity)
	{
		return getRepository().save(entity);
	}
	
	default void deleteById(ID id)
	{
		getRepository().delete(id);
	}
	
	default E update(E entity)
	{	
		return getRepository().save(entity);
	}
	
	CrudRepository<E,ID> getRepository();
}
