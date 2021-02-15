package com.kuzmin.bookstore.service;

import com.kuzmin.bookstore.domain.entity.Author;
import com.kuzmin.bookstore.domain.entity.Book;
import com.kuzmin.bookstore.repository.AuthorRepository;
import com.kuzmin.bookstore.repository.BookRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable("books")
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Cacheable("books")
    public Book getBookByAuthorName(String name) {
        return bookRepository.findByAuthorsName(name).orElse(null);
    }

    @CachePut("books")
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @CacheEvict("books")
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }
}
