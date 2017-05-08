package com.workshop.refactoring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.workshop.refactoring.FizzBuzz.translate;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class FizzBuzzTests {

    private final Integer number;
    private final String expected;

    public FizzBuzzTests(Integer number, String expected) {
        this.number = number;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, "Fizz"}, {3 * 2, "Fizz"},
                {5, "Buzz"}, {5 * 2, "Buzz"},
                {15, "FizzBuzz"}, {15 * 2, "FizzBuzz"},
                {1, "1"}, {2, "2"}, {4, "4"}, {8, "8"},
        });
    }

    @Test
    public void test() throws Exception {
        assertThat(translate(number), is(expected));
    }
}