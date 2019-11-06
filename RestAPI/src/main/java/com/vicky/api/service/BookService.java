package com.vicky.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vicky.api.model.Book;


@Service
public interface BookService {
	   long save(Book book);
	   Book get(long id);
	   List<?> bookList();
	   void update(long id, Book book);
	   void delete(long id);

	}
