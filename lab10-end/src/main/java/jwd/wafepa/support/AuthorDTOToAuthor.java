package jwd.wafepa.support;

import java.util.ArrayList;

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.web.dto.AuthorDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorDTOToAuthor implements Converter<AuthorDTO, Author> {

	//TODO implementirati preuzimanje knjiga iz baze pri kreiranju autora
	
	@Override
	public Author convert(AuthorDTO arg0) {
		return new Author(arg0.getId(), arg0.getFirstName(), arg0.getLastName(), new ArrayList<Book>());
	}

}
