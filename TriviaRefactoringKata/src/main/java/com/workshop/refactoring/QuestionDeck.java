package com.workshop.refactoring;

public class QuestionDeck {
    public String createRockQuestion(int index) {
        return "Rock Question " + index;
    }

    void fillQuestions(Game game) {
        for (int i = 0; i < 50; i++) {
            game.popQuestions.addLast("Pop Question " + i);
            game.scienceQuestions.addLast(("Science Question " + i));
            game.sportsQuestions.addLast(("Sports Question " + i));
            game.rockQuestions.addLast(createRockQuestion(i));
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

    void askQuestion(String currentCategory, Game game) {
        if (currentCategory == "Pop")
            System.out.println(game.popQuestions.removeFirst());
        if (currentCategory == "Science")
            System.out.println(game.scienceQuestions.removeFirst());
        if (currentCategory == "Sports")
            System.out.println(game.sportsQuestions.removeFirst());
        if (currentCategory == "Rock")
            System.out.println(game.rockQuestions.removeFirst());
    }
}
