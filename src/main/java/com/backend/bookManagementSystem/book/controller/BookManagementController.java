package com.backend.bookManagementSystem.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, value = "/book")
    public void addBook(@RequestBody Book book) {
        bookManagementService.addBook(book);
    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.PUT, value = "/book/{code}")
    public void updateBook(@RequestBody Book book, @PathVariable long code) throws Exception {
        boolean result = bookManagementService.updateBook(code, book);
        if (result == false) {
            throw new Exception("no book found to update book_code : " + code);
        }

    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping(method = RequestMethod.DELETE, value = "/book/{code}")
    public void deleteBook(@PathVariable long code) {
        System.out.println(code);
        bookManagementService.deleteBook(code);

    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping("/book/bookIds")
    public Long[] bookIds() throws Exception {
        return bookManagementService.getBookIds();

    }


}