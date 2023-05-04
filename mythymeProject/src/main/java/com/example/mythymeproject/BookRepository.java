package com.example.mythymeproject;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Books, String> {
    @Query("{'isbn':  ?0}")
    List<Books> findBooksByIsbn(String isbn);
}
