package com.vicky.api.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vicky.api.dao.BookDao;
import com.vicky.api.model.Book;
@Transactional
@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	SessionFactory sessionFactory;
	private Session session;
	
	@Override
	public long save(Book book) {
		session =  sessionFactory.getCurrentSession();
		Statistics stats = this.sessionFactory.getStatistics(); 
		System.out.println("before operation : "+stats);
		session.save(book);
		System.out.println("after operation : "+stats);
		return book.getId();
	}

	@Override
	public Book get(long id) {
		session =  sessionFactory.getCurrentSession();
		return (Book) session.get(Book.class, id);
	}

	@Override
	public List<?> bookList() {
		 Session session = sessionFactory.getCurrentSession();
	      Criteria criteria = session.createCriteria(Book.class);
	      return (List<?>)criteria.list();
	}

	@Override
	public void update(long id, Book book) {
		session =  sessionFactory.getCurrentSession();
		Statistics stats = this.sessionFactory.getStatistics(); 
		System.out.println("before operation : "+stats);
		Book book2 = (Book) session.byId(Book.class).load(id);
	      book2.setTitle(book.getTitle());
	      book2.setAuthor(book.getAuthor());
	      System.out.println("after operation : "+stats);
	}

	@Override
	public void delete(long id) {
		  Session session = sessionFactory.getCurrentSession();
	      Book book = (Book) session.byId(Book.class).load(id);
	      session.delete(book);

	}

	/*
	 * @Override public void close() throws Exception { if(session != null) {
	 * session.flush(); session.close(); }
	 * 
	 * }
	 */

}
