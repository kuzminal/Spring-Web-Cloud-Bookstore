package com.kuzmin.bookstore.model;

import com.kuzmin.bookstore.domain.i18n.MultiLangDocument;
import lombok.Data;

import java.util.Set;

@Data
public class AuthorDTO {
    private String id;
    private String name;
    private int age;
    private String imgId;
    private String imgData;
}
