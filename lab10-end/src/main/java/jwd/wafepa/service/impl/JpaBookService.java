package jwd.wafepa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Book;
import jwd.wafepa.repository.BookRepository;
import jwd.wafepa.service.BookService;

@Service
public class JpaBookService implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Page<Book> findAll(int page) {
		return bookRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Page<Book> findByPrice(double priceFrom, double priceTo, int page) {
		return bookRepository.findByPriceLessThanAndPriceGreaterThan(priceTo, priceFrom, new PageRequest(page, 10));
	}

}
