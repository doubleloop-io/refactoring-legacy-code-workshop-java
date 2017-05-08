package com.workshop.refactoring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.workshop.refactoring.FizzBuzz.translate;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FizzBuzzTests {

    @Test
    @Parameters({
            "3, Fizz", "6, Fizz",
            "5, Buzz", "10, Buzz",
            "7, Yo!",
            "15, FizzBuzz", "30, FizzBuzz",
            "1, 1", "2, 2", "4, 4", "8, 8",
    })
    public void convertNumber(Integer number, String expected) throws Exception {
        assertThat(translate(number), is(expected));
    }
}