package com.book.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import com.book.entity.Book;
import com.book.repository.BookRepository;
import com.book.service.BookService;

@Service
public class BookserviceImpl implements BookService {
	@Autowired
	private BookRepository bookrepository;

	// return all books
	public List<Book> getAllBooks() {
		List<Book> allbooks = bookrepository.findAll();
		return allbooks;
	}

	// return book
	public Book getBook(int id) {
		try {
			Optional<Book> findById = bookrepository.findById(id);
			if(findById.isPresent()) {
				Book book = findById.get();
				return book;
			}else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// add book
	public Book addBook(Book book) {
		Book save = bookrepository.save(book);
		return save;
	}

	// delete book
	public void deleteBook(int id) {
		try {
			bookrepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update the book
	public Book updateBook(Book book, int bookid) {
		try {
			Optional<Book> findById = bookrepository.findById(bookid);
			if (findById.isPresent()) {
				Book book2 = findById.get();
				book2.setName(book.getName());
				book2.setAuthor(book.getAuthor());
				return bookrepository.save(book2);
			} else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
