package com.workshop.refactoring;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CategoryQuestionsTests {
    @Test
    public void placeWithCategory() throws Exception {
        final CategoryQuestions categoryQuestions = new CategoryQuestions("anything", Arrays.asList(1, 2));
        assertThat(categoryQuestions.contains(1), is(true));
        assertThat(categoryQuestions.contains(2), is(true));
    }
}