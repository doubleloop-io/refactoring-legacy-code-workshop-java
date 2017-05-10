package com.workshop.refactoring;

public class UnknownCategoryException extends RuntimeException {
    public UnknownCategoryException(String category) {
        super("Unknown category: " + category);
    }
}
