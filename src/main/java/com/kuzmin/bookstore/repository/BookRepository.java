package com.kuzmin.bookstore.repository;

import com.kuzmin.bookstore.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
}
