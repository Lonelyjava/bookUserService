package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.BookEntity;

public interface BookService {

	
	public BookEntity save(BookDto bookDto);
	
	public BookEntity search(long id);
}
