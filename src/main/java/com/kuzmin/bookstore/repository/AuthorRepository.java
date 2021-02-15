package com.kuzmin.bookstore.repository;

import com.kuzmin.bookstore.domain.entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends MongoRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
