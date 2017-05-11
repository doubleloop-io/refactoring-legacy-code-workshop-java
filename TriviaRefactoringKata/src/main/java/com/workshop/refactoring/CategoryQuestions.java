package com.workshop.refactoring;

import java.util.LinkedList;
import java.util.List;

public class CategoryQuestions {

    private final String name;
    private final LinkedList questions;
    private final List<Integer> places;

    public CategoryQuestions(String name, List<Integer> places) {
        this.name = name;
        this.questions = new LinkedList();
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public void addQuestion(String question) {
        questions.addLast(question);
    }

    public boolean isPlacedOn(int place) {
        return places.contains(place);
    }

    public Object nextQuestion() {
        return questions.removeFirst();
    }
}
