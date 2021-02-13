package com.kuzmin.bookstore.service;

import com.kuzmin.bookstore.domain.entity.Author;
import com.kuzmin.bookstore.repository.AuthorRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Cacheable("authors")
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @CachePut("authors")
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @CacheEvict("authors")
    public void deleteAllAuthors() {
        authorRepository.deleteAll();
    }
}
