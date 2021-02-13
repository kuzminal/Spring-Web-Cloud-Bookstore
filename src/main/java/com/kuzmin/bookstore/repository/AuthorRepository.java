package com.kuzmin.bookstore.repository;

import com.kuzmin.bookstore.domain.entity.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
