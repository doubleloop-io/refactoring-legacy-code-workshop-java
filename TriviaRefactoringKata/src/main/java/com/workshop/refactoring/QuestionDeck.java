package com.workshop.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

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
        categories.stream()
                .flatMap(c -> IntStream.range(0, 50)
                        .mapToObj(i -> new Pair<>(c, createQuestion(c.getName(), i))))
                .forEach(p -> p.left.addQuestion(p.right));
    }

    String categoryFor(int place) {
        return categories.stream()
                .filter(c -> c.isPlacedOn(place))
                .findFirst()
                .orElseThrow(() -> new OutOfBoardPlaceException(place))
                .getName();
    }

    Object nextQuestion(String category) {
        return categories.stream()
                .filter(c -> Objects.equals(category,c.getName()))
                .findFirst()
                .orElseThrow(()-> new UnknownCategoryException(category))
                .nextQuestion();
    }

    private final class Pair<A, B> {
        private final A left;
        private final B right;

        public Pair(A left, B right) {
            this.left = left;
            this.right = right;
        }
    }
}
