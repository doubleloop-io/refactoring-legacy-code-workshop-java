package com.workshop.refactoring;

import java.util.Random;

import static java.lang.Integer.parseInt;

public class GameRunner {

    private static boolean notAWinner;

    public static void main(String[] args) {
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        Random rand;
        if (args.length > 0)
        {
            final int seed = parseInt(args[0]);
            rand = new Random(seed);
        }
        else{
            rand = new Random();
        }

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
