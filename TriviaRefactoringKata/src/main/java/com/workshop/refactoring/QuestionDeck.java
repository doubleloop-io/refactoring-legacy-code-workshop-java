package com.workshop.refactoring;

import java.util.*;
import java.util.stream.IntStream;

public class QuestionDeck {
    private final Map<String, CategoryQuestions> categories;

    public QuestionDeck() {
        categories = new HashMap<>();
    }

    private String createQuestion(String category, int index) {
        return category + " Question " + index;
    }

    void fillQuestions() {
        CategoryQuestions pop = new CategoryQuestions("Pop");
        categories.put(pop.getName(), pop);
        pop.placeOn(Arrays.asList(0, 4, 8));

        CategoryQuestions science = new CategoryQuestions("Science");
        categories.put(science.getName(), science);
        science.placeOn(Arrays.asList(1, 5, 9));

        CategoryQuestions sports = new CategoryQuestions("Sports");
        categories.put(sports.getName(), sports);
        sports.placeOn(Arrays.asList(2, 6, 10));

        CategoryQuestions rock = new CategoryQuestions("Rock");
        rock.placeOn(Arrays.asList(3, 7, 11));
        categories.put(rock.getName(), rock);

        categories.values().stream()
                .flatMap(c -> IntStream.range(0, 50)
                        .mapToObj(i -> new Pair<>(c, createQuestion(c.getName(), i))))
                .forEach(p -> p.left.addQuestion(p.right));
    }

    String categoryFor(int place) {
        return categories.values().stream()
                .filter(c -> c.isPlacedOn(place))
                .findFirst()
                .orElseThrow(() -> new UndefinedCategoryException(place))
                .getName();
    }

    Object nextQuestion(String category) {
        return categories.values().stream()
                .filter(c -> Objects.equals(category, c.getName()))
                .findFirst()
                .orElseThrow(() -> new UnknownCategoryException(category))
                .nextQuestion();
    }

    public void placeOn(String category, List<Integer> places) {
        if (categories.containsKey(category)) {
            final CategoryQuestions categoryQuestions = categories.get(category);
            categoryQuestions.placeOn(places);
        } else {
            final CategoryQuestions categoryQuestions = new CategoryQuestions(category);
            categories.put(category, categoryQuestions);
            categoryQuestions.placeOn(places);
        }
    }

    public void addQuestion(String category, String question) {
        if (categories.containsKey(category)) {
            final CategoryQuestions categoryQuestions = categories.get(category);
            categoryQuestions.addQuestion(question);
        } else {
            final CategoryQuestions categoryQuestions = new CategoryQuestions(category);
            categories.put(category, categoryQuestions);
            categoryQuestions.addQuestion(question);
        }
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
