package com.workshop.refactoring;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class QuestionDeckTests {

    @Test
    public void placeWithCategory() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.placeOn("something", Arrays.asList(1, 2));
        final String category = deck.categoryFor(2);
        assertThat(category, is("something"));
    }

    @Test
    public void placeWithoutCategory() throws Exception {
        final Integer place = 3;
        final QuestionDeck deck = new QuestionDeck();
        deck.placeOn("anything", Arrays.asList(1, 2));
        try {
            deck.categoryFor(place);
            fail("expected exception to be thrown");
        } catch (Exception e) {
            assertThat(e, instanceOf(UndefinedCategoryException.class));
            assertThat(e.getMessage(), containsString(place.toString()));
        }
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
        deck.addQuestion("something", "a question");
        try {
            deck.nextQuestion("boh");
            fail("expected exception to be thrown");
        } catch (Exception e) {
            assertThat(e, instanceOf(UnknownCategoryException.class));
            assertThat(e.getMessage(), containsString("boh"));
        }
    }

    @Test
    public void multipleQuestionsForSameCategory() throws Exception {
        final String category = "cat1";
        final QuestionDeck deck = new QuestionDeck();
        deck.addQuestion(category, "foo");
        deck.addQuestion(category, "bar");
        assertThat(deck.nextQuestion(category), is("foo"));
        assertThat(deck.nextQuestion(category), is("bar"));
    }

    @Test
    public void multipleQuestionsForMixedCategories() throws Exception {
        final QuestionDeck deck = new QuestionDeck();
        deck.addQuestion("cat1", "foo");
        deck.addQuestion("cat1", "bar");
        deck.addQuestion("cat2", "alpha");
        deck.addQuestion("cat3", "beta");
        assertThat(deck.nextQuestion("cat1"), is("foo"));
        assertThat(deck.nextQuestion("cat3"), is("beta"));
        assertThat(deck.nextQuestion("cat2"), is("alpha"));
        assertThat(deck.nextQuestion("cat1"), is("bar"));
    }
}