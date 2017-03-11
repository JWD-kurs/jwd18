package jwd.wafepa.support;

import jwd.wafepa.model.Book;
import jwd.wafepa.web.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookDTOToBook implements Converter<BookDTO, Book> {

	@Autowired
	AuthorDTOToAuthor aDTO2a;
	
	@Override
	public Book convert(BookDTO arg0) {
		return new Book(arg0.getId(), arg0.getTitle(), 
				arg0.getPrice(), arg0.getYear(), aDTO2a.convert(arg0.getAuthor()));
	}

}
