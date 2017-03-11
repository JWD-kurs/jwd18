package jwd.wafepa.service;

import jwd.wafepa.model.Book;

import org.springframework.data.domain.Page;

public interface BookService {

	Book save(Book book);

	Page<Book> findAll(int page);
	
	Page<Book> findByPrice(double priceFrom, double priceTo, int page);
}
