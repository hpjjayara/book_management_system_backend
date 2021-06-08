/**
 *
 * @author Jayathi_Hewapathirana
 
 */
package com.backend.bookManagementSystem.book.controller;


import com.backend.bookManagementSystem.author.controller.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
//    public Book findByBookId(long authorId);

    public  Book findByName(String bookName);

    public static final String FIND_BOOK_IDS = "SELECT code FROM book";

    @Query(value = FIND_BOOK_IDS, nativeQuery = true)
    public Long[] findBookIds();

    long deleteByCode(long code);

}
