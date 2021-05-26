package com.backend.bookManagementSystem.author.controller;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

//    public List<Author> findById(long id);


}
