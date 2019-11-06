package com.vicky.api.dao;

import java.util.List;

import com.vicky.api.model.Book;

public interface BookDao {

	   long save(Book book);
	   Book get(long id);
	   List<?> bookList();
	   void update(long id, Book book);
	   void delete(long id);

	}
