package com.backend.bookManagementSystem.author.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public List<Author> getAllAuthorDetails() {
        List<Author> authorList = new ArrayList<>();
        authorRepository.findAll().forEach(authorList::add);
        return authorList;

    }


    public Author getAuthor(long id) {
        return authorRepository.findById(id).orElse(null);
    }


    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(long id) {
        authorRepository.deleteById(id);
    }
}
