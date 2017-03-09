package org.sapient.persistance.repositoires;

import org.sapient.persistance.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{}