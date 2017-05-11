package com.workshop.refactoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class QuestionDeck {
    private final Map<String, CategoryQuestions> categories;

    public QuestionDeck() {
        categories = new HashMap<>();
    }

    public String createDummyQuestion(String category, int index) {
        return category + " Question " + index;
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
