package com.workshop.refactoring;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class QuestionDeckTests {
    @Test
    public void popPlace() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        final String category = deck.currentCategory(0);
        assertThat(category, is("Pop"));
    }

    @Test
    public void secondPopPlace() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        final String category = deck.currentCategory(4);
        assertThat(category, is("Pop"));
    }
}