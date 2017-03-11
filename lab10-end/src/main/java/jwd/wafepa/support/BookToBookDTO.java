package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Book;
import jwd.wafepa.web.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDTO 
	implements Converter<Book, BookDTO>{

	@Autowired
	AuthorToAuthorDTO a2aDTO;
	
	@Override
	public BookDTO convert(Book arg0) {
		return new BookDTO(arg0.getId(), arg0.getTitle(), 
				arg0.getPrice(), arg0.getYear(), a2aDTO.convert(arg0.getAuthor()));
	}
	
	public List<BookDTO> convert(List<Book> books){
		List<BookDTO> retVal = new ArrayList<>();
		for (Book book : books) {
			retVal.add(convert(book));
		}
		return retVal;
	}

	
}
