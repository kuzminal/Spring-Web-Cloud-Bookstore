package com.kuzmin.bookstore.repository;

import com.kuzmin.bookstore.domain.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    Optional<Book> findByAuthorsName(String name);
}
