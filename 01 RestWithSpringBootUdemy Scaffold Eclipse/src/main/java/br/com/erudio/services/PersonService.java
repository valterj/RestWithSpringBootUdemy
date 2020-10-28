package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;

	public Person create(Person person) {
		return repository.save(person);
	}

	public Person update(Person person) {
		Person entity = this.findById(person.getId());
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}

	public Person findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No record found for this id"));
	}

	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public void delete(Long id) {
		Person entity = this.findById(id);
		repository.delete(entity);
	}

}
