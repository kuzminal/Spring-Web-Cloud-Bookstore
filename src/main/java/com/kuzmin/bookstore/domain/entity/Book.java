package com.kuzmin.bookstore.domain.entity;

import com.kuzmin.bookstore.domain.enums.Genre;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String annotation;
    @ManyToMany(mappedBy = "books")
    @OrderBy("name DESC")
    private Set<Author> authors = new HashSet<>();
}
