package com.example.demo.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BookEntity;

@Repository
public interface BookReposistory extends JpaRepository<BookEntity , Long>{
	
	public BookEntity findById(long id);

}
