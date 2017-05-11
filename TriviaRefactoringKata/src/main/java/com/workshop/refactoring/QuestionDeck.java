package com.workshop.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class QuestionDeck {
    private final ArrayList<CategoryQuestions> categories;

    public QuestionDeck() {
        CategoryQuestions pop = new CategoryQuestions("Pop");
        pop.placeOn(Arrays.asList(0, 4, 8));
        CategoryQuestions science = new CategoryQuestions("Science");
        science.placeOn(Arrays.asList(1, 5, 9));
        CategoryQuestions sports = new CategoryQuestions("Sports");
        sports.placeOn(Arrays.asList(2, 6, 10));
        CategoryQuestions rock = new CategoryQuestions("Rock");
        rock.placeOn(Arrays.asList(3, 7, 11));

        categories = new ArrayList<>();
        categories.add(pop);
        categories.add(science);
        categories.add(sports);
        categories.add(rock);
    }

    private String createQuestion(String category, int index) {
        return category + " Question " + index;
    }

    void fillQuestions() {
        for (CategoryQuestions c : categories) {
            for (int i = 0; i < 50; i++) {
                c.addQuestion(createQuestion(c.getName(), i));
            }
        }
    }

    String categoryFor(int place) {
        for (CategoryQuestions c : categories) {
            if (c.isPlacedOn(place))
                return c.getName();
        }

        throw new OutOfBoardPlaceException(place);
    }

    Object nextQuestion(String category) {
        for (CategoryQuestions c : categories) {
            if (Objects.equals(category, c.getName()))
                return c.nextQuestion();
        }

        throw new UnknownCategoryException(category);
    }
}
