package com.workshop.refactoring;

import java.util.Arrays;
import java.util.Objects;

public class QuestionDeck {
    private final CategoryQuestions pop;
    private final CategoryQuestions science;
    private final CategoryQuestions sports;
    private final CategoryQuestions rock;

    public QuestionDeck() {
        pop = new CategoryQuestions("Pop");
        pop.placeOn(Arrays.asList(0, 4, 8));
        science = new CategoryQuestions("Science");
        science.placeOn(Arrays.asList(1, 5, 9));
        sports = new CategoryQuestions("Sports");
        sports.placeOn(Arrays.asList(2, 6, 10));
        rock = new CategoryQuestions("Rock");
        rock.placeOn(Arrays.asList(3, 7, 11));
    }

    private String createQuestion(String category, int index) {
        return category + " Question " + index;
    }

    void fillQuestions() {
        for (int i = 0; i < 50; i++) {
            pop.addQuestion(createQuestion(pop.getName(), i));
            science.addQuestion(createQuestion(science.getName(), i));
            sports.addQuestion(createQuestion(sports.getName(), i));
            rock.addQuestion(createQuestion(rock.getName(), i));
        }
    }

    String categoryFor(int place) {
        if (pop.isPlacedOn(place)) return pop.getName();
        if (science.isPlacedOn(place)) return science.getName();
        if (sports.isPlacedOn(place)) return sports.getName();
        if (rock.isPlacedOn(place)) return rock.getName();

        throw new OutOfBoardPlaceException(place);
    }

    Object nextQuestion(String category) {
        if (Objects.equals(category, pop.getName())) return pop.nextQuestion();
        if (Objects.equals(category, science.getName())) return science.nextQuestion();
        if (Objects.equals(category, sports.getName())) return sports.nextQuestion();
        if (Objects.equals(category, rock.getName())) return rock.nextQuestion();

        throw new UnknownCategoryException(category);
    }
}
