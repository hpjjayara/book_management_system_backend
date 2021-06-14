/**
 *
 * @author Jayathi_Hewapathirana
 
 */
package com.backend.bookManagementSystem.book.controller;

import com.backend.bookManagementSystem.author.controller.Author;
import com.backend.bookManagementSystem.author.controller.AuthorService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long code;
    private String name;
    private String authorName;
    @Column(length = 1000, nullable = false)
    private String description;
    private int stockCount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {

    }

//    public Book(long code, String name, String description, int stockCount, long authorId) {
//        this.code = code;
//        this.name = name;
//        this.description = description;
//        this.stockCount = stockCount;
////        this.author = authorId;
//    }


    public Book(long code, String name, String authorName, String description, int stockCount, long authorId) {
        this.code = code;
        this.name = name;
        this.authorName = authorName;
        this.description = description;
        this.stockCount = stockCount;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return authorName;
    }

    public void setAuthor(String author) {
        this.authorName = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

//    public long getAuthor_id() {
//        return author_id;
//    }
//
//    public void setAuthor_id(long author_id) {
//        this.author_id = author_id;
//    }
}
