/**
 *
 * @author Jayathi_Hewapathirana
 * @version 1.0

 */

package com.backend.bookManagementSystem.author.controller;

import com.backend.bookManagementSystem.book.controller.Book;
import com.backend.bookManagementSystem.book.controller.BookManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AuthorController {


    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookManagementService bookManagementService;

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping("/author")
    public List<Author> getAllAuthorDetails() {
        return authorService.getAllAuthorDetails();
    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping("/author/{id}")
    public Author getAuthor(@PathVariable long id) {
        return authorService.getAuthor(id);
    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, value = "/author")
    public void addAuthor(@RequestBody Author author) {
//        ArrayList<Book> bookArrayList = new ArrayList<>();
//        bookArrayList.add(new Book(bookCode,"","","",0));
//        bookManagementService.addBook(book);
//        authorService.addAuthor(author);

        authorService.addAuthor(author);
    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.PUT, value = "/author/{id}")
    public void updateAuthor(@RequestBody Author author, @PathVariable long id) {
//        ArrayList<Book> bookArrayList = new ArrayList<>();
//        bookArrayList.add(new Book(bookCode,"","","",0));
//        author.setBook(bookArrayList);
        authorService.updateAuthor(author);

    }

    @CrossOrigin
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @RequestMapping(method = RequestMethod.DELETE, value = "/author/{id}")
    public void deleteAuthor(@PathVariable long id) {
        authorService.deleteAuthor(id);

    }


}
