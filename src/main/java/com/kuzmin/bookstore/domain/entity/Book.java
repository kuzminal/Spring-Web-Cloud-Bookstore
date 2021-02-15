package com.kuzmin.bookstore.domain.entity;

import com.kuzmin.bookstore.domain.enums.Genre;
import com.kuzmin.bookstore.domain.i18n.MultiLangDocument;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Document(collection = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @TextIndexed
    private Set<MultiLangDocument> title;
    @Indexed(name = "isbn", direction = IndexDirection.ASCENDING)
    private String isbn;
    private Genre genre;
    private String annotation;
    @Field("authors")
    private Set<Author> authors = new HashSet<>();
}
