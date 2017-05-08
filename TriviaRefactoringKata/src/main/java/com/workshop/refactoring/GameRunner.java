package com.workshop.refactoring;

import java.util.Random;

public class GameRunner {

    private boolean notAWinner;

    public static void main(String[] args) {
        final GameRunner runner = new GameRunner();
        runner.run();
    }

    private void run() {
        Game aGame = new Game();

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        Random rand = createRandom();

        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }


        } while (notAWinner);
    }

    private Random createRandom() {
        return new Random(8);
    }
}
