package com.kuzmin.bookstore.controller.api;

import com.kuzmin.bookstore.domain.entity.Author;
import com.kuzmin.bookstore.model.AuthorDTO;
import com.kuzmin.bookstore.service.AuthorService;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import java.util.List;

@RestController
@RequestMapping("api/authors")
public class AuthorsApiController {
    private final AuthorService authorService;

    public AuthorsApiController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("{id}")
    public AuthorDTO getAuthorById(@PathVariable ObjectId id) {
        return authorService.getAuthorById(id, LocaleContextHolder.getLocale());
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }
}
