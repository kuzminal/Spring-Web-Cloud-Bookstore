package com.kuzmin.bookstore.service;

import com.kuzmin.bookstore.domain.entity.Author;
import com.kuzmin.bookstore.domain.entity.Book;
import com.kuzmin.bookstore.domain.i18n.MultiLangDocument;
import com.kuzmin.bookstore.testdata.AuthorTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static com.kuzmin.bookstore.testdata.BookTestData.getBook1;
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
        Author author = getAuthor1();
        author.setImgId(authorService.saveAuthorIcon());
        Author storedAuthor = authorService.saveAuthor(author);
        Author authorGotten = authorService.getAuthorById(storedAuthor.getId());
        assertThat(storedAuthor).isEqualToIgnoringGivenFields(authorGotten,"id", "imgData");
    }

    @Test
    public void getAuthorByName() throws IOException {
        Author storedAuthor = authorService.saveAuthor(getAuthor1());
        MultiLangDocument multiLangDocument = new MultiLangDocument();
        multiLangDocument.language = "en";
        multiLangDocument.text = "Aleksey Kuzmin";
        Author author = authorService.getAuthorByName(multiLangDocument);
        assertThat(author).isEqualToIgnoringGivenFields(storedAuthor,"id");
    }

    @Test
    public void getAuthorFullTextSearchRu() throws IOException {
        Author storedAuthor = authorService.saveAuthor(getAuthor1());
        List<Author> authors = authorService.fullTextSearchAuthor("кузьмин");
        assertThat(storedAuthor).isIn(authors);
    }

    @Test
    public void getAuthorFullTextSearchEn() throws IOException {
        Author storedAuthor = authorService.saveAuthor(getAuthor1());
        List<Author> authors = authorService.fullTextSearchAuthor("kuzmin");
        assertThat(storedAuthor).isIn(authors);
    }

    @Test
    public void storeAuthorIcon() throws IOException {
        String id = authorService.saveAuthorIcon();
        System.out.println(id);
    }

    @Test
    public void getAuthorIcon() throws IOException {
        String id = authorService.saveAuthorIcon();
        String icon = authorService.getAuthorIcon(id);
        System.out.println(icon);
    }
}
