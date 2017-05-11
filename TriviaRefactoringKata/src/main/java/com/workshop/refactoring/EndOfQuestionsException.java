package com.workshop.refactoring;

public class EndOfQuestionsException extends RuntimeException {
    public EndOfQuestionsException(String category) {
        super("End of questions for: " + category);
    }
}
