package com.workshop.refactoring;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class QuestionDeck {
    private final Map<String, CategoryQuestions> categories;

    public QuestionDeck() {
        categories = new HashMap<>();
    }

    private String createDummyQuestion(String category, int index) {
        return category + " Question " + index;
    }

    void fillQuestions() {
        placeFiftyDummyQuestions("Pop", Arrays.asList(0, 4, 8));
        placeFiftyDummyQuestions("Science", Arrays.asList(1, 5, 9));
        placeFiftyDummyQuestions("Sports", Arrays.asList(2, 6, 10));
        placeFiftyDummyQuestions("Rock", Arrays.asList(3, 7, 11));
    }

    private void placeFiftyDummyQuestions(String category, List<Integer> places) {
        placeOn(category, places);
        IntStream.range(0, 50).mapToObj(x -> createDummyQuestion(category, x))
                .forEach(x -> addQuestion(category, x));
    }

    String categoryFor(int place) {
        return findCategoryOrThrow(c -> c.isPlacedOn(place), () -> new UndefinedCategoryException(place))
                .getName();
    }

    Object nextQuestion(String category) {
        return findCategoryOrThrow(c -> Objects.equals(category, c.getName()), () -> new UnknownCategoryException(category))
                .nextQuestion();
    }

    public void placeOn(String category, List<Integer> places) {
        getOrAdd(category).placeOn(places);
    }

    public void addQuestion(String category, String question) {
        getOrAdd(category).addQuestion(question);
    }

    private CategoryQuestions getOrAdd(String category) {
        CategoryQuestions categoryQuestions;
        if (categories.containsKey(category)) {
            categoryQuestions = categories.get(category);
        } else {
            categoryQuestions = new CategoryQuestions(category);
            categories.put(category, categoryQuestions);
        }
        return categoryQuestions;
    }

    private <X extends RuntimeException> CategoryQuestions findCategoryOrThrow(Predicate<CategoryQuestions> predicate, Supplier<? extends X> exceptionSupplier) {
        return categories.values().stream()
                .filter(predicate)
                .findFirst()
                .orElseThrow(exceptionSupplier);
    }
}
