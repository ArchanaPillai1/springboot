package com.application.springbootexample.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.springbootexample.model.Book;

@RestController
public class BookController {

	List<Book> booklist = new ArrayList<Book>();

	/**
	 * create Object and Return object URL :
	 * http://localhost:9090/spring-boot/addBookByPathVar/42/Spring Boot Services/Ujwala/500
	 * 
	 * @param id
	 * @param name
	 * @param author
	 * @param price
	 * @return
	 */
	@RequestMapping("/addBookByPathVar/{id}/{name}/{author}/{price}")
	Book addBookByPathVariables(@PathVariable Long id, @PathVariable String name,
			@PathVariable String author, @PathVariable BigDecimal price) {

		Book bookObj = new Book(id, name, author, price);
		booklist.add(bookObj);
		return bookObj;

	}

	/**
	 * it Returns all List of Books
	 * 
	 * @return
	 */
	@RequestMapping("/getAllBooks")
	List<Book> getAllBooks() {
		return this.booklist;
	}

	/**
	 * method = POST , url= http://localhost:9090/spring-boot/addBookByParam?id=54&name=Java&author=Nileema&price=580
	 * 
	 * @param id
	 * @param name
	 * @param author
	 * @param price
	 * @return
	 */
	@RequestMapping(value = "/addBookByParam", method = RequestMethod.POST)
	Book addBookByReqParam(@RequestParam(name = "id", required = false, defaultValue = "-999") Long id,
			@RequestParam(name = "name", required = false, defaultValue = "NA") String name,
			@RequestParam(name = "author", required = false, defaultValue = "Unknown") String author,
			@RequestParam(name = "price", required = false, defaultValue = "0") BigDecimal price) {

		Book bookObj = new Book(id, name, author, price);
		booklist.add(bookObj);
		return bookObj;

	}

	/**
	 * method =Post Request - post JSON data through post request
	 * 
	 * @param book
	 * @return
	 */
	@RequestMapping(value = "/addBookJson", method = RequestMethod.POST)
	List<Book> postMethod(@RequestBody Book book) {
		booklist.add(book);
		return this.booklist;
	}

}
