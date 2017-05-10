package com.workshop.refactoring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class QuestionDeckTests {

    @Test
    @Parameters({
            "0,Pop", "4,Pop", "8,Pop",
            "1,Science", "5,Science", "9,Science",
            "2,Sports", "6,Sports", "10,Sports",
            "3,Rock", "7,Rock", "11,Rock",
    })
    public void categoryForPlace(Integer place, String expected) throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        final String category = deck.currentCategory(place);
        assertThat(category, is(expected));
    }

    @Test
    @Parameters({"12", "555", "-1", "" + Integer.MAX_VALUE })
    public void outOfBoardPlace(Integer place) throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        final String category = deck.currentCategory(place);
        assertThat(category, is("Rock"));
    }

   @Ignore("not ready yet") @Test
    public void firstQuestionForPop() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.fillQuestions();
        deck.askQuestion("Pop");
        // assert what??
    }
}