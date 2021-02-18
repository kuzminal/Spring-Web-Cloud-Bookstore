package com.kuzmin.bookstore.util;

import java.util.Base64;

public class CommonUtils {
    public static String makeDataUrl(String contentType, byte[] content) {
        String dataUrl = "data:";
        byte[] encodedBytes = Base64.getEncoder().encode(content);
        dataUrl = dataUrl + contentType + ";base64," + new String(encodedBytes);
        return dataUrl;
    }
}
