/**
 *
 * @author Jayathi_Hewapathirana

 */
package com.backend.bookManagementSystem.author.controller;


import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "author")
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long author_id;
    private String name;
    private LocalDate dateOfBirth;
    private String country;

//    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    private List<Book> book;

    public Author() {

    }

    public Author(long id, String name, LocalDate dateOfBirth, String country) {
        super();
        this.author_id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
    }

    public long getId() {
        return author_id;
    }

    public void setId(long id) {
        this.author_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public List<Book> getBook() {
//        return book;
//    }
//
//    public void setBook(List<Book> book) {
//        this.book = book;
//    }

}
