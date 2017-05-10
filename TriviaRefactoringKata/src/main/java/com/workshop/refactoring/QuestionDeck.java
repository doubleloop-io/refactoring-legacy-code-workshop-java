package com.workshop.refactoring;

import java.util.LinkedList;
import java.util.Objects;

public class QuestionDeck {
    private final LinkedList popQuestions;
    private final LinkedList scienceQuestions;
    private final LinkedList sportsQuestions;
    private final LinkedList rockQuestions;

    public QuestionDeck() {
        popQuestions = new LinkedList();
        scienceQuestions = new LinkedList();
        sportsQuestions = new LinkedList();
        rockQuestions = new LinkedList();
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
        if (currentPlayerPlace == 3) return "Rock";
        if (currentPlayerPlace == 7) return "Rock";
        if (currentPlayerPlace == 11) return "Rock";
        return "Rock";
    }

    Object askQuestion(String currentCategory) {
        if (Objects.equals(currentCategory, "Pop")) {
            final Object question = popQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (Objects.equals(currentCategory, "Science")) {
            final Object question = scienceQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (Objects.equals(currentCategory, "Sports")) {
            final Object question = sportsQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        if (Objects.equals(currentCategory, "Rock")) {
            final Object question = rockQuestions.removeFirst();
            System.out.println(question);
            return question;
        }
        return null;
    }
}
