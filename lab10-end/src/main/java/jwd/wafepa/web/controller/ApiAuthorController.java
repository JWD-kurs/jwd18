package jwd.wafepa.web.controller;

import java.util.List;

import jwd.wafepa.model.Author;
import jwd.wafepa.service.AuthorService;
import jwd.wafepa.support.AuthorToAuthorDTO;
import jwd.wafepa.web.dto.AuthorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/authors")
public class ApiAuthorController {

	@Autowired
	AuthorService authorService;
	
	@Autowired
	AuthorToAuthorDTO a2aDTO;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<AuthorDTO>> getAuthors() {

		List<Author> authors;

		authors = authorService.findAll();
		return new ResponseEntity<>(a2aDTO.convert(authors), HttpStatus.OK);
	}

}
