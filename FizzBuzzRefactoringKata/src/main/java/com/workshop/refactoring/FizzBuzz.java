package com.workshop.refactoring;

import java.util.Objects;

public class FizzBuzz {
    public static String translate(Integer number) {
        String result = "";
        if (number % 15 == 0) {
            result = "FizzBuzz";
            return result;
        }
        else if (number % 3 == 0) {
            result = "Fizz";
            return result;
        }
        else if (number % 5 == 0) {
            result = "Buzz";
            return result;
        }
        if (Objects.equals(result, ""))
            return Objects.toString(number);
        else
            return result;
    }
}
