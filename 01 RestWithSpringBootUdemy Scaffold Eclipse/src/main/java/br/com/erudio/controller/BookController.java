package br.com.erudio.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.data.vo.BookVO;
import br.com.erudio.services.BookService;

@RestController
@RequestMapping("api/book/v1")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping
	public List<BookVO> findAll() {
		List<BookVO> books = this.service.findAll();
		books.stream()				
				.forEach(p -> p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel()));
		return books;
	}

	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	public BookVO findById(@PathVariable("id") Long id) {
		BookVO bookVO = this.service.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}

	@PostMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public BookVO create(@RequestBody BookVO book) {
		BookVO bookVO = this.service.create(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}

	@PutMapping(produces = { "application/json", "application/xml" }, consumes = { "application/json",
			"application/xml" })
	public BookVO update(@RequestBody BookVO book) {
		BookVO bookVO = this.service.update(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		this.service.delete(id);
	}

}
