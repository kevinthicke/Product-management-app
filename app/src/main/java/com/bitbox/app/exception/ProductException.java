package com.bitbox.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class ProductIdNotUnique extends RuntimeException {
        public ProductIdNotUnique(long id) {
            super(String.format("Product with id %d already exists", id));
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class ProductIsNotActive extends RuntimeException {
        public ProductIsNotActive(long id) {
            super(String.format("Product with id %d must be active", id));
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ProductNotFound extends RuntimeException {
        public ProductNotFound(long id) {
            super(String.format("Product with id %d not found", id));
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static class ProductIdCannotBeModified extends RuntimeException {
        public ProductIdCannotBeModified() {
            super("Product Id cannot be modified");
        }
    }
}
