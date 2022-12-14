package com.joshua.com.relationshipCRUD.utils.responses;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
