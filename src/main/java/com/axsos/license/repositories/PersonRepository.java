package com.axsos.license.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.license.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long>  {
	 Optional<Person> findById(Long id);
	List<Person> findAll() ;
	 
}
