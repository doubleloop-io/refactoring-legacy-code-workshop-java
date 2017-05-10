package com.workshop.refactoring;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class QuestionDeck {
    private final LinkedList popQuestions;
    private final List<Integer> popPlaces;

    private final LinkedList scienceQuestions;
    private final List<Integer> sciencePlaces;

    private final LinkedList sportsQuestions;
    private final List<Integer> sportsPlaces;

    private final LinkedList rockQuestions;
    private final List<Integer> rockPlaces;

    public QuestionDeck() {
        popQuestions = new LinkedList();
        popPlaces = Arrays.asList(0, 4, 8);

        scienceQuestions = new LinkedList();
        sciencePlaces = Arrays.asList(1, 5, 9);

        sportsQuestions = new LinkedList();
        sportsPlaces = Arrays.asList(2, 6, 10);

        rockQuestions = new LinkedList();
        rockPlaces = Arrays.asList(3, 7, 11);
    }

    private String createQuestion(String category, int index) {
        return category + " Question " + index;
    }

    void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(createQuestion("Pop", i));
            scienceQuestions.addLast(createQuestion("Science", i));
            sportsQuestions.addLast(createQuestion("Sports", i));
            rockQuestions.addLast(createQuestion("Rock", i));
        }
    }

    String categoryFor(int place) {
        if (popPlaces.contains(place)) return "Pop";
        if (sciencePlaces.contains(place)) return "Science";
        if (sportsPlaces.contains(place)) return "Sports";
        if (rockPlaces.contains(place)) return "Rock";

        throw new OutOfBoardPlaceException(place);
    }

    Object nextQuestion(String category) {
        Object question = null;
        LinkedList questions = null;

        if (Objects.equals(category, "Pop")) questions = this.popQuestions;
        if (Objects.equals(category, "Science")) questions = this.scienceQuestions;
        if (Objects.equals(category, "Sports")) questions = this.sportsQuestions;
        if (Objects.equals(category, "Rock")) questions = this.rockQuestions;

        if (questions != null) question = questions.removeFirst();
        else throw new UnknownCategoryException(category);

        return question;
    }
}
