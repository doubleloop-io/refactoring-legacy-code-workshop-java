package com.workshop.refactoring;

import java.util.Objects;

public class FizzBuzz {
    public static String translate(Integer number) {
        if (number % 15 == 0)
            return "FizzBuzz";
        if (number % 3 == 0)
            return "Fizz";
        if (number % 5 == 0)
            return "Buzz";
        if (number % 7 == 0)
            return "Yo!";
        return Objects.toString(number);
    }
}
