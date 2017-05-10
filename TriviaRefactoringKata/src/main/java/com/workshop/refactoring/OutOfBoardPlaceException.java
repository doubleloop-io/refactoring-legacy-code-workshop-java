package com.workshop.refactoring;

public class OutOfBoardPlaceException extends RuntimeException {
    public OutOfBoardPlaceException(Integer place) {
        super("No category defined for an out of board place: " + place);
    }
}
