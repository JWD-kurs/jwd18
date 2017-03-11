package jwd.wafepa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Author;
import jwd.wafepa.repository.AuthorRepository;
import jwd.wafepa.service.AuthorService;

@Service
public class JpaAuthorService implements AuthorService{

	@Autowired
	AuthorRepository authorRepository;
	
	@Override
	public Author save(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

}
