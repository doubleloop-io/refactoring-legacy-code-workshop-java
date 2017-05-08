package com.workshop.refactoring;

import java.util.Objects;

public class FizzBuzz {
    public static String translate(Integer number) {
        String result;
        if (number % 15 == 0) {
            result = "FizzBuzz";
            return  result;
        }
        if (number % 3 == 0) {
            result = "Fizz";
            return  result;
        }
        if (number % 5 == 0) {
            result = "Buzz";
            return result;
        }
        return Objects.toString(number);
    }
}
