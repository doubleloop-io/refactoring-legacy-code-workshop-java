package com.workshop.refactoring;

public class UndefinedCategoryException extends RuntimeException {
    public UndefinedCategoryException(Integer place) {
        super("No category defined for place: " + place);
    }
}
