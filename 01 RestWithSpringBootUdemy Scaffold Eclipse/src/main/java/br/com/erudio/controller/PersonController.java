package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping
	public List<PersonVO> findAll() {
		return this.service.findAll();
	}

	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable("id") Long id) {
		return this.service.findById(id);
	}

	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) {
		return this.service.create(person);
	}

	@PutMapping
	public PersonVO update(@RequestBody PersonVO person) {
		return this.service.update(person);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.service.delete(id);
	}

}
