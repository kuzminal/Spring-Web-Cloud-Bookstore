package com.kuzmin.bookstore.service;

import com.kuzmin.bookstore.domain.entity.Author;
import com.kuzmin.bookstore.domain.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.kuzmin.bookstore.testdata.BookTestData.BOOK1;
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
    public void getBook(){
        Book storedAuthor = bookService.saveBook(BOOK1);
        Book book = bookService.getBookById(storedAuthor.getId());
        assertThat(book).isEqualToIgnoringGivenFields(BOOK1,"id", "authors");
    }

    @Test
    public void getBookByAuthor(){
        Book storedBook = bookService.saveBook(BOOK1);
        Book book = bookService.getBookByAuthorName("Alex");
        assertThat(book).isEqualToIgnoringGivenFields(BOOK1,"id", "authors");
    }
}
