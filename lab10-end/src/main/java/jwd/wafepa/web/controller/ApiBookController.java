package jwd.wafepa.web.controller;

import java.util.List;

import jwd.wafepa.model.Book;
import jwd.wafepa.service.BookService;
import jwd.wafepa.support.BookDTOToBook;
import jwd.wafepa.support.BookToBookDTO;
import jwd.wafepa.web.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/books")
public class ApiBookController {

	@Autowired
	BookToBookDTO b2bDTO;
	
	@Autowired
	BookDTOToBook bDTO2b;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<BookDTO>> getBooks(
			@RequestParam(value = "priceFrom", defaultValue = "0") double priceFrom,
			@RequestParam(value = "priceTo", defaultValue = "1000000") double priceTo,
			@RequestParam(value = "page", defaultValue = "0") int page) {

		Page<Book> books;

		books = bookService.findByPrice(priceFrom, priceTo, page);
		return new ResponseEntity<>(b2bDTO.convert(books.getContent()), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<BookDTO> add(@RequestBody BookDTO newBook) {

		Book savedBook = bookService.save(bDTO2b
				.convert(newBook));

		return new ResponseEntity<>(b2bDTO.convert(savedBook), HttpStatus.CREATED);
	}

}
