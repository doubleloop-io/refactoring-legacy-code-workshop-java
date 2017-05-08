package com.workshop.refactoring;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TryTestRunnerTests {

    @Test
    public void pass() throws Exception {
        assertThat("a", is("a"));
    }

    @Test
    public void fail() throws Exception {
        assertThat("b", is("a"));
    }
}
