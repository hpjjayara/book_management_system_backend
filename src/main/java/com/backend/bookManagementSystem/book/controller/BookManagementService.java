package com.backend.bookManagementSystem.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookManagementService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooksDetails() {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().forEach(bookList::add);
        return bookList;

    }

    public Long[] getBookIds() throws Exception{
        Long[] bookIds = bookRepository.findBookIds();
        for (int i = 0; i<bookIds.length; i++){

        }
        return bookIds;

    }


    public Book getBook(long code) {
        return bookRepository.findById(code).orElse(null);
    }


    public void addBook(Book book) {
        String newBookName = book.getName();
        Book oldBook = bookRepository.findByName(newBookName);

        if (oldBook != null && oldBook.getName().equals(book.getName())){
                return;
        }
        bookRepository.save(book);

    }

    public boolean updateBook(long code, Book book) {
        Book oldBook = bookRepository.findById(code).orElse(null);
        if (oldBook != null && oldBook.getCode() == code){
            bookRepository.save(book);
            return true;
        }
        return false;

    }


    public void deleteBook(long code) {
        Book oldBook = bookRepository.findById(code).orElse(null);
        if (oldBook != null && oldBook.getCode() == code) {
            bookRepository.deleteById(code);
        }
    }


}
