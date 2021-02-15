package com.kuzmin.bookstore.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    @Indexed(name = "author_name", direction = IndexDirection.ASCENDING)
    @TextIndexed
    private String name;
    private int age;
    //@Field("books")
    //private Set<Book> books = new HashSet<>();
}
