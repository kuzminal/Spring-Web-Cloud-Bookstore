package com.kuzmin.bookstore.service;

import com.kuzmin.bookstore.domain.entity.Author;
import com.kuzmin.bookstore.domain.entity.Book;
import com.kuzmin.bookstore.domain.i18n.MultiLangDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

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
        Book storedBook = bookService.saveBook(getBook1());
        Book book = bookService.getBookById(storedBook.getId());
        assertThat(book).isEqualToIgnoringGivenFields(getBook1(),"id", "authors");
    }

    @Test
    public void getBookByIsbn() throws IOException {
        Book storedBook = bookService.saveBook(getBook1());
        Book book = bookService.getBookByIsbn("1bdw3ff");
        assertThat(book).isEqualToIgnoringGivenFields(storedBook,"id", "authors");
    }

    @Test
    public void getBookByAuthor() throws IOException {
        Book storedBook = bookService.saveBook(getBook1());
        MultiLangDocument multiLangDocument = new MultiLangDocument();
        multiLangDocument.language = "en";
        multiLangDocument.text = "Aleksey Kuzmin";
        Book book = bookService.getBookByAuthorName(multiLangDocument);
        assertThat(book).isEqualToIgnoringGivenFields(storedBook,"id", "authors");
    }

    @Test
    public void fullTextSearchBooksTitleForRuLang() throws IOException {
        Book storedBook = bookService.saveBook(getBook1());
        List<Book> books = bookService.fullTextSearchBook("властелин");
        assertThat(storedBook).isIn(books);
    }

    @Test
    public void fullTextSearchBooksTitleForEnLang() throws IOException {
        Book storedBook = bookService.saveBook(getBook1());
        List<Book> books = bookService.fullTextSearchBook("Lord");
        assertThat(storedBook).isIn(books);
    }

    @Test
    public void fullTextSearchBooksAuthorForRuLang() throws IOException {
        Book storedBook = bookService.saveBook(getBook1());
        List<Book> books = bookService.fullTextSearchBook("Кузьмин");
        assertThat(storedBook).isIn(books);
    }

    @Test
    public void fullTextSearchBooksAuthorForEnLang() throws IOException {
        Book storedBook = bookService.saveBook(getBook1());
        List<Book> books = bookService.fullTextSearchBook("Kuzmin");
        assertThat(storedBook).isIn(books);
    }
}
