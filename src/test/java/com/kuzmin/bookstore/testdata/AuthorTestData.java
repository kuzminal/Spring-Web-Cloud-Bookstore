package com.kuzmin.bookstore.testdata;

import com.kuzmin.bookstore.domain.entity.Author;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;

import java.io.IOException;
import java.io.InputStream;

public class AuthorTestData {
    public static Binary getPhoto() throws IOException {
        Binary img;
        ClassLoader classLoader = AuthorTestData.class.getClassLoader();
        try (InputStream file = classLoader.getResourceAsStream("images/author_photo.png")) {
            assert file != null;
            img = new Binary(BsonBinarySubType.BINARY, file.readAllBytes());
        }
        return img;
    }

    public static Author getAuthor1() throws IOException {
        return new Author(
                1L, "Alex", 20, getPhoto()
        );
    }
}
