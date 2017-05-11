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

    private String createQuestion(String category, int index) {
        return category + " Question " + index;
    }

    void fillQuestions() {
        CategoryQuestions pop = new CategoryQuestions("Pop");
        categories.put(pop.getName(), pop);
        pop.placeOn(Arrays.asList(0, 4, 8));
        IntStream.range(0,50).mapToObj(x -> createQuestion(pop.getName(), x))
                .forEach(pop::addQuestion);

        CategoryQuestions science = new CategoryQuestions("Science");
        categories.put(science.getName(), science);
        science.placeOn(Arrays.asList(1, 5, 9));
        IntStream.range(0,50).mapToObj(x -> createQuestion(science.getName(), x))
                .forEach(science::addQuestion);

        CategoryQuestions sports = new CategoryQuestions("Sports");
        categories.put(sports.getName(), sports);
        sports.placeOn(Arrays.asList(2, 6, 10));
        IntStream.range(0,50).mapToObj(x -> createQuestion(sports.getName(), x))
                .forEach(sports::addQuestion);

        CategoryQuestions rock = new CategoryQuestions("Rock");
        rock.placeOn(Arrays.asList(3, 7, 11));
        categories.put(rock.getName(), rock);
        IntStream.range(0,50).mapToObj(x -> createQuestion(rock.getName(), x))
                .forEach(rock::addQuestion);
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
