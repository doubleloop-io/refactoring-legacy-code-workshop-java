package com.workshop.refactoring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class QuestionDeckTests {

    @Test
    @Parameters({
            "0,Pop", "4,Pop", "8,Pop",
            "1,Science", "5,Science", "9,Science",
            "2,Sports", "6,Sports", "10,Sports",
            "3,Rock", "7,Rock", "11,Rock",
    })
    public void categoryForPlace_(Integer place, String expected) throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.fillQuestions();
        final String category = deck.categoryFor(place);
        assertThat(category, is(expected));
    }

    @Test
    public void categoryForPlace() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.placeOn("something", Arrays.asList(1,2));
        final String category = deck.categoryFor(2);
        assertThat(category, is("something"));
    }

    @Test
    @Parameters({"12", "555", "-1", "" + Integer.MAX_VALUE})
    public void outOfBoardPlace(Integer place) throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.fillQuestions();
        try {
            deck.categoryFor(place);
            fail("expected exception to be thrown");
        } catch (Exception e) {
            assertThat(e, instanceOf(OutOfBoardPlaceException.class));
            assertThat(e.getMessage(), containsString(place.toString()));
        }
    }

    @Test
    @Parameters({
            "Pop, Pop Question 0",
            "Science, Science Question 0",
            "Sports, Sports Question 0",
            "Rock, Rock Question 0",
    })
    public void firstQuestion(String category, Object expected) throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.fillQuestions();
        final Object question = deck.nextQuestion(category);
        assertThat(question, is(expected));
    }

    @Test
    public void questionForUnknownCategory() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.fillQuestions();
        try {
            deck.nextQuestion("boh");
            fail("expected exception to be thrown");
        } catch (Exception e) {
            assertThat(e, instanceOf(UnknownCategoryException.class));
            assertThat(e.getMessage(), containsString("boh"));
        }
    }

    @Test
    @Parameters({
            "Pop",
            "Science",
            "Sports",
            "Rock",
    })
    public void multipleQuestionsForSameCategory(String category) throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.fillQuestions();
        assertThat(deck.nextQuestion(category), is(category + " Question 0"));
        assertThat(deck.nextQuestion(category), is(category + " Question 1"));
        assertThat(deck.nextQuestion(category), is(category + " Question 2"));
        assertThat(deck.nextQuestion(category), is(category + " Question 3"));
    }

    @Test
    public void multipleQuestionsForMixedCategories() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.fillQuestions();
        assertThat(deck.nextQuestion("Pop"), is("Pop Question 0"));
        assertThat(deck.nextQuestion("Sports"), is("Sports Question 0"));
        assertThat(deck.nextQuestion("Pop"), is("Pop Question 1"));
        assertThat(deck.nextQuestion("Sports"), is("Sports Question 1"));
        assertThat(deck.nextQuestion("Rock"), is("Rock Question 0"));
    }
}