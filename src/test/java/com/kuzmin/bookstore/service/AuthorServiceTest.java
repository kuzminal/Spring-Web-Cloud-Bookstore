package com.kuzmin.bookstore.service;

import com.kuzmin.bookstore.domain.entity.Author;
import com.kuzmin.bookstore.testdata.AuthorTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static com.kuzmin.bookstore.testdata.AuthorTestData.getAuthor1;

@SpringBootTest
public class AuthorServiceTest {
    @Autowired
    private AuthorService authorService;
    
    @BeforeEach
    public void saveAuthor() {
        authorService.deleteAllAuthors();
    }

    @Test
    public void getAuthor() throws IOException {
        Author storedAuthor = authorService.saveAuthor(getAuthor1());
        Author author = authorService.getAuthorById(storedAuthor.getId());
        assertThat(author).isEqualToIgnoringGivenFields(getAuthor1(),"id");
    }
}
