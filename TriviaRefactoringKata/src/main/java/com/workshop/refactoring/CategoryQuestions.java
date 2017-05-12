package com.workshop.refactoring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class CategoryQuestions {

    private final String name;
    private final LinkedList questions;
    private final List<Integer> places;

    CategoryQuestions(String name) {
        this.name = name;
        this.questions = new LinkedList();
        this.places = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    void addQuestion(String question) {
        questions.addLast(question);
    }

    boolean isPlacedOn(int place) {
        return places.contains(place);
    }

    Object nextQuestion() {
        if (questions.size() == 0) throw new EndOfQuestionsException(name);
        return questions.removeFirst();
    }

    void placeOn(List<Integer> places) {
        this.places.addAll(places);
    }
}
