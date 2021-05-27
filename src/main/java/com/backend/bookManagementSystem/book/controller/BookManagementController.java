package com.backend.bookManagementSystem.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookManagementController {


    @Autowired
    private BookManagementService bookManagementService;

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping("/book")
    public List<Book> getAllBooksDetails() {
        return bookManagementService.getAllBooksDetails();

    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping("/book/{code}")
    public List<Book> getBook(@PathVariable long code) {
        List<Book> books = new ArrayList<Book>();
        books.add(bookManagementService.getBook(code));
        return books;
    }

    @CrossOrigin
//    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, value = "/book")
    public String addBook(@RequestBody Book book) throws Exception {
        try {
            boolean result = bookManagementService.addBook(book);
            if (result == false) {
                throw new AlreadyExistsBookException();
            }
            return "Book is added Successfully.";
        }catch (AlreadyExistsBookException ex){
//            return "Cannot add book: "+ex.getMessage();

            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Book Not Found", ex);
        }

    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.PUT, value = "/book/{code}")
    public String updateBook(@RequestBody Book book, @PathVariable long code) throws Exception {
        try {
        boolean result = bookManagementService.updateBook(code, book);
        if (result == false) {
            throw new AlreadyExistsBookException();
        }
            return "Book is updated Successfully.";
        }catch (AlreadyExistsBookException ex){
//            return "Cannot add book: "+ex.getMessage();

            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED, "Book Not Found", ex);
        }


    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping(method = RequestMethod.DELETE, value = "/book/{code}")
    public String  deleteBook(@PathVariable long code) {
        try {
            boolean result = bookManagementService.deleteBook(code);
            if (result == false) {
                throw new AlreadyAcceptedBookException();
            }
            return "Book is deleted Successfully.";
        }catch (AlreadyAcceptedBookException ex){
//            return "Cannot add book: "+ex.getMessage();

            throw new ResponseStatusException(HttpStatus.ACCEPTED, "Book Not Found", ex);
        }


    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping("/book/bookIds")
    public Long[] bookIds() throws Exception {
        return bookManagementService.getBookIds();

    }

    @ResponseStatus(code = HttpStatus.ALREADY_REPORTED, reason = "Book already exists")
    public class AlreadyExistsBookException extends Exception {

    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Book already accepted")
    public class AlreadyAcceptedBookException extends Exception {

    }



}