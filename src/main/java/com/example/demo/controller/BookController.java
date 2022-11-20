package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.BookEntity;
import com.example.demo.response.ResponseAPI;
import com.example.demo.service.BookService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/book")
@Api(value="/book" , tags="Book Management System")
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody BookDto bookDto) {
		ResponseAPI api = new ResponseAPI();
		BookEntity bookEntity = bookService.save(bookDto);
		api.setResponseMessage("saved successfully0");
		api.setResponseCode(200);
		api.setError(false);
		api.setData(bookEntity);
		return new ResponseEntity<>(api, HttpStatus.OK);
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> search(@PathVariable long id) {
		ResponseAPI api = new ResponseAPI();
		BookEntity bookEntity = bookService.search(id);
		api.setResponseMessage("search records .");
		api.setResponseCode(200);
		api.setError(false);
		api.setData(bookEntity);
		return new ResponseEntity<>(api, HttpStatus.OK);
	}
}
