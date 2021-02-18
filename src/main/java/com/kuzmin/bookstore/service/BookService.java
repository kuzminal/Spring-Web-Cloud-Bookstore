package com.kuzmin.bookstore.service;

import com.kuzmin.bookstore.domain.entity.Book;
import com.kuzmin.bookstore.domain.i18n.MultiLangDocument;
import com.kuzmin.bookstore.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final MongoTemplate mongoTemplate;

    public BookService(BookRepository bookRepository, MongoTemplate mongoTemplate) {
        this.bookRepository = bookRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Cacheable("books")
    public Book getBookById(ObjectId id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Cacheable("books")
    public Book getBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElse(null);
    }

    @Cacheable("books")
    public Book getBookByAuthorName(MultiLangDocument name) {
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

    @Cacheable("books")
    public List<Book> fullTextSearchBook(String searchCriteria) {
        TextCriteria criteria = TextCriteria.forDefaultLanguage()
                .matching(searchCriteria)
                .caseSensitive(false);

        Query query = TextQuery.queryText(criteria)
                .sortByScore()
                .with(PageRequest.of(0, 5));
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }
}
