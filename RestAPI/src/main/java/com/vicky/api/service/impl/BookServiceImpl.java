package com.vicky.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vicky.api.dao.BookDao;
import com.vicky.api.model.Book;
import com.vicky.api.service.BookService;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

   @Autowired
   private BookDao bookDao;

   @Transactional
   @Override
   public long save(Book book) {
      return bookDao.save(book);
   }

   @Override
   public Book get(long id) {
      return bookDao.get(id);
   }

   @Override
   public List<?> bookList() {
      return bookDao.bookList();
   }

   @Transactional
   @Override
   public void update(long id, Book book) {
      bookDao.update(id, book);
   }

   @Transactional
   @Override
   public void delete(long id) {
      bookDao.delete(id);
   }
}
