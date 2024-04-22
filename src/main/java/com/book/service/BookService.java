package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface BookService {
	public List<Book> getAllBooks();
	public Book getBook(int id);
	public Book updateBook(Book book, int bookid);
	public void deleteBook(int id);
	public Book addBook(Book book);

}
