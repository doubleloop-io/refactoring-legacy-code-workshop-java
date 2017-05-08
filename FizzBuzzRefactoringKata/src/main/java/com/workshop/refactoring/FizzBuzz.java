package com.workshop.refactoring;

import java.util.Objects;

public class FizzBuzz {
    public static String translate(Integer number) {
        String result = "";

        if (number % 3 == 0) result += "Fizz";
        if (number % 5 == 0) result += "Buzz";
        if (number % 7 == 0) result += "Yo!";

        if (Objects.equals(result, ""))
            return Objects.toString(number);
        else
            return result;
    }
}
