package com.kuzmin.bookstore.testdata;

import com.kuzmin.bookstore.domain.entity.Book;
import com.kuzmin.bookstore.domain.enums.Genre;
import com.kuzmin.bookstore.domain.i18n.MultiLangDocument;

import java.util.Collections;
import java.util.Set;

import static com.kuzmin.bookstore.testdata.AuthorTestData.AUTHOR1;

public class BookTestData {
    public static final Book BOOK1 = new Book(
            1L,
            Set.of(new MultiLangDocument("ru", "Властелин колец"),
                    new MultiLangDocument("en", "Lord of The Rings")),
            "1bdw3ff", Genre.FANTASY, "Best book", Set.of(AUTHOR1)
    );
}
