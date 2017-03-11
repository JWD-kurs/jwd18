package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import jwd.wafepa.model.Author;
import jwd.wafepa.web.dto.AuthorDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorDTO implements Converter<Author, AuthorDTO>{

	@Override
	public AuthorDTO convert(Author arg0) {
		return new AuthorDTO(arg0.getId(), arg0.getFirstName(), arg0.getLastName());
	}

	
	public List<AuthorDTO> convert(List<Author> authors){
		List<AuthorDTO> retVal = new ArrayList<>();
		for (Author author : authors) {
			retVal.add(convert(author));
		}
		return retVal;
	}
}
