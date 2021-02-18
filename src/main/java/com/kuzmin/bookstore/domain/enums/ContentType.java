package com.kuzmin.bookstore.domain.enums;

public enum ContentType {
    PNG("image/png"),
    JPG("image/jpg");

    private final String contentType;

    public String getContentType() {
        return contentType;
    }

    ContentType(String contentType) {
        this.contentType = contentType;
    }
}
