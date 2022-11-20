package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.BookEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.reposistory.BookReposistory;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookReposistory bookReposistory;
	
//	@Autowired
//	RestTemplate restTemplate;
	
	

	@Override
	public BookEntity save(BookDto bookDto) {
		
		BookEntity bookEntity = new BookEntity();
		bookEntity.setAuthorName(bookDto.getAuthorName());
		bookEntity.setBookName(bookDto.getBookName());
//		bookEntity.setUser_id(bookDto.getUser_id());
		LocalDateTime date = LocalDateTime.now();
		bookEntity.setCreateDate(date);
		// TODO Auto-generated method stub
		bookReposistory.save(bookEntity);
		return bookEntity;
	}

	@Override
	public BookEntity search(long id) {

		String url ="http://localhost:8081/user/search/"+id;
//		UserEntity userList = restTemplate.getForObject(url, UserEntity.class);
		BookEntity bookEntity=bookReposistory.findById(id);
		bookEntity.setUserEntity(null);
		return bookEntity;
	}

}
