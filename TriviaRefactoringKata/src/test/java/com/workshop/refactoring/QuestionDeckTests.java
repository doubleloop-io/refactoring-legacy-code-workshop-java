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
    public void placeWithCategory() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.placeOn("something", Arrays.asList(1,2));
        final String category = deck.categoryFor(2);
        assertThat(category, is("something"));
    }

    @Test
    public void placeWithoutCategory() throws Exception {
        final Integer place = 3;
        final QuestionDeck deck = new QuestionDeck();
        deck.placeOn("anything", Arrays.asList(1,2));
        try {
            deck.categoryFor(place);
            fail("expected exception to be thrown");
        } catch (Exception e) {
            assertThat(e, instanceOf(UndefinedCategoryException.class));
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
    public void firstQuestion() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.addQuestion("something", "a question");
        final Object question = deck.nextQuestion("something");
        assertThat(question, is("a question"));
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