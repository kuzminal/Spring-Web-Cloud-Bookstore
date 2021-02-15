package com.kuzmin.bookstore.service;

import com.kuzmin.bookstore.domain.entity.Author;
import com.kuzmin.bookstore.domain.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import static com.kuzmin.bookstore.testdata.BookTestData.getBook1;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @BeforeEach
    public void saveAuthor() {
        bookService.deleteAllBooks();
    }

    @Test
    public void getBook() throws IOException {
        Book storedAuthor = bookService.saveBook(getBook1());
        Book book = bookService.getBookById(storedAuthor.getId());
        assertThat(book).isEqualToIgnoringGivenFields(getBook1(),"id", "authors");
    }

    @Test
    public void getBookByAuthor() throws IOException {
        Book storedBook = bookService.saveBook(getBook1());
        Book book = bookService.getBookByAuthorName("Alex");
        assertThat(book).isEqualToIgnoringGivenFields(getBook1(),"id", "authors");
    }
}
