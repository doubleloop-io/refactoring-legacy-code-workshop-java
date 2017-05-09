package com.workshop.refactoring;

import java.util.LinkedList;

public class QuestionDeck {
    private final Game game;
    private final LinkedList popQuestions;
    private final LinkedList scienceQuestions;
    private final LinkedList sportsQuestions;
    private final LinkedList rockQuestions;

    public QuestionDeck(Game game) {

        this.game = game;
        popQuestions = game.popQuestions;
        scienceQuestions = game.scienceQuestions;
        sportsQuestions = game.sportsQuestions;
        rockQuestions = game.rockQuestions;
    }

    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    String currentCategory(int currentPlayerPlace) {
        if (currentPlayerPlace == 0) return "Pop";
        if (currentPlayerPlace == 4) return "Pop";
        if (currentPlayerPlace == 8) return "Pop";
        if (currentPlayerPlace == 1) return "Science";
        if (currentPlayerPlace == 5) return "Science";
        if (currentPlayerPlace == 9) return "Science";
        if (currentPlayerPlace == 2) return "Sports";
        if (currentPlayerPlace == 6) return "Sports";
        if (currentPlayerPlace == 10) return "Sports";
        return "Rock";
    }

    void askQuestion(String currentCategory) {
        if (currentCategory == "Pop")
            System.out.println(popQuestions.removeFirst());
        if (currentCategory == "Science")
            System.out.println(scienceQuestions.removeFirst());
        if (currentCategory == "Sports")
            System.out.println(sportsQuestions.removeFirst());
        if (currentCategory == "Rock")
            System.out.println(rockQuestions.removeFirst());
    }
}
