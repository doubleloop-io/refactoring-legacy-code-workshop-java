package com.workshop.refactoring;

import java.util.Arrays;
import java.util.Random;

public class GameRunner {

    private static boolean notAWinner;

    public static void main(String[] args) {
        run(new Random());
    }

    public static void run(Random rand) {
        Game aGame = new Game();

        aGame.placeFiftyDummyQuestion("Pop", Arrays.asList(0, 4, 8));
        aGame.placeFiftyDummyQuestion("History", Arrays.asList(1, 5, 9));
        aGame.placeFiftyDummyQuestion("Sports", Arrays.asList(2, 6, 10));
        aGame.placeFiftyDummyQuestion("Rock", Arrays.asList(3, 7, 11));

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");


        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }


        } while (notAWinner);
    }
}
