package com.kuzmin.bookstore.testdata;

import com.kuzmin.bookstore.domain.entity.Book;
import com.kuzmin.bookstore.domain.enums.Genre;
import com.kuzmin.bookstore.domain.i18n.MultiLangDocument;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;

import java.io.*;
import java.util.Set;

import static com.kuzmin.bookstore.testdata.AuthorTestData.getAuthor1;

public class BookTestData {

    public static Binary getCover() throws IOException {
        Binary img;
        ClassLoader classLoader = BookTestData.class.getClassLoader();
        try (InputStream file = classLoader.getResourceAsStream("images/bookshop.jpg")) {
            assert file != null;
            img = new Binary(BsonBinarySubType.BINARY, file.readAllBytes());
        }
        return img;
    }

    public static Book getBook1() throws IOException {
        Book book1 = new Book(
                1L,
                Set.of(new MultiLangDocument("ru", "Властелин колец"),
                        new MultiLangDocument("en", "Lord of The Rings")),
                "1bdw3ff", Genre.FANTASY, "Best book", getCover(), Set.of(getAuthor1()));
        return book1;
    }
}
