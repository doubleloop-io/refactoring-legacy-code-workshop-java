package com.workshop.refactoring;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class CategoryQuestionsTests {

    @Test
    public void placeWithCategory() throws Exception {
        final CategoryQuestions categoryQuestions = new CategoryQuestions("anything");
        categoryQuestions.placeOn(Arrays.asList(1, 2));
        assertThat(categoryQuestions.isPlacedOn(1), is(true));
        assertThat(categoryQuestions.isPlacedOn(2), is(true));
    }

    @Test
    public void placeWithoutCategory() throws Exception {
        final CategoryQuestions categoryQuestions = new CategoryQuestions("anything");
        categoryQuestions.placeOn(Arrays.asList(1, 2));
        assertThat(categoryQuestions.isPlacedOn(3), is(false));
        assertThat(categoryQuestions.isPlacedOn(4), is(false));
    }

    @Test
    public void askQuestions() throws Exception {
        final CategoryQuestions categoryQuestions = new CategoryQuestions("anything");
        categoryQuestions.addQuestion("first");
        categoryQuestions.addQuestion("second");
        assertThat(categoryQuestions.nextQuestion(), is("first"));
        assertThat(categoryQuestions.nextQuestion(), is("second"));
    }

    @Test
    public void tooManyQuestions() throws Exception {
        final String category = "anything";
        final CategoryQuestions categoryQuestions = new CategoryQuestions(category);
        categoryQuestions.addQuestion("first");
        categoryQuestions.nextQuestion();
        try {
            categoryQuestions.nextQuestion();
            fail("expected exception to be thrown");
        } catch (Exception e) {
            assertThat(e, instanceOf(EndOfQuestionsException.class));
            assertThat(e.getMessage(), containsString(category));
        }
    }

    @Test
    public void exposeName() throws Exception {
        final String category = "me";
        final CategoryQuestions categoryQuestions = new CategoryQuestions(category);
        assertThat(categoryQuestions.getName(), is(category));
    }
}