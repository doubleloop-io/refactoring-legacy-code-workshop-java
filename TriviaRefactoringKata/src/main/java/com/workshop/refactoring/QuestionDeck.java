package com.workshop.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class QuestionDeck {
    private final ArrayList<CategoryQuestions> categories;

    public QuestionDeck() {
        categories = new ArrayList<>();
    }

    private String createQuestion(String category, int index) {
        return category + " Question " + index;
    }

    void fillQuestions() {
        CategoryQuestions pop = new CategoryQuestions("Pop");
        categories.add(pop);
        pop.placeOn(Arrays.asList(0, 4, 8));

        CategoryQuestions science = new CategoryQuestions("Science");
        categories.add(science);
        science.placeOn(Arrays.asList(1, 5, 9));

        CategoryQuestions sports = new CategoryQuestions("Sports");
        categories.add(sports);
        sports.placeOn(Arrays.asList(2, 6, 10));

        CategoryQuestions rock = new CategoryQuestions("Rock");
        rock.placeOn(Arrays.asList(3, 7, 11));
        categories.add(rock);

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
                .filter(c -> Objects.equals(category, c.getName()))
                .findFirst()
                .orElseThrow(() -> new UnknownCategoryException(category))
                .nextQuestion();
    }

    public void placeOn(String category, List<Integer> places) {
        final CategoryQuestions categoryQuestions = new CategoryQuestions(category);
        categories.add(categoryQuestions);
        categoryQuestions.placeOn(places);
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
