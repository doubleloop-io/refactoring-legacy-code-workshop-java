package com.workshop.refactoring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class QuestionDeckTests {

    @Test
    @Parameters({"0", "4", "8"})
    public void popPlaces(Integer place) throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        final String category = deck.currentCategory(place);
        assertThat(category, is("Pop"));
    }
}