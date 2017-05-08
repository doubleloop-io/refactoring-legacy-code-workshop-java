package com.workshop.refactoring;

import java.util.Objects;

public class FizzBuzz {
    public static String translate(Integer number) {
        if (number % 15 == 0) {
            String result;
            result = "FizzBuzz";
            return  result;
        }
        if (number % 3 == 0) {
            String result;
            result = "Fizz";
            return  result;
        }
        if (number % 5 == 0) {
            String result;
            result = "Buzz";
            return result;
        }
        return Objects.toString(number);
    }
}
