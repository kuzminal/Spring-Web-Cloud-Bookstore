package com.kuzmin.bookstore.service;

import com.kuzmin.bookstore.domain.entity.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.kuzmin.bookstore.testdata.AuthorTestData.AUTHOR1;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthorServiceTest {
    @Autowired
    private AuthorService authorService;
    
    @BeforeEach
    public void saveAuthor() {
        authorService.deleteAllAuthors();
    }

    @Test
    public void getAuthor(){
        Author storedAuthor = authorService.saveAuthor(AUTHOR1);
        Author author = authorService.getAuthorById(storedAuthor.getId());
        assertThat(author).isEqualToIgnoringGivenFields(AUTHOR1,"id");
    }
}
