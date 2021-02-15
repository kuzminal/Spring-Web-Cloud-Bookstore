package com.kuzmin.bookstore.domain.i18n;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Language;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiLangDocument {
    @Language
    public String language;
    @TextIndexed
    public String text;
}
