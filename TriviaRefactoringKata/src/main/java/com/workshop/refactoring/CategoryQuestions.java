package com.workshop.refactoring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CategoryQuestions {

    private final String name;
    private final LinkedList questions;
    private List<Integer> places;

    public CategoryQuestions(String name) {
        this.name = name;
        this.questions = new LinkedList();
        this.places = new ArrayList<>();
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
        if (questions.size() == 0) throw new EndOfQuestionsException(name);
        return questions.removeFirst();
    }

    public void placeOn(List<Integer> places) {
        this.places = places;
    }
}
