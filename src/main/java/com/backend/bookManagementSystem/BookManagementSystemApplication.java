/**
 *
 * @author Jayathi_Hewapathirana
 
 */
package com.backend.bookManagementSystem;

import com.backend.bookManagementSystem.author.controller.AuthorRepository;
import com.backend.bookManagementSystem.book.controller.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookManagementSystemApplication.class, args);

    }



}
