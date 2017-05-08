package com.workshop.refactoring;

import org.junit.Test;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.Random;

public class SpikeTests {
    @Test
    public void runGame() throws Exception {
        File file = Paths.get("output.log").toFile();
        System.setOut(new PrintStream(file));
        for (int i = 0; i < 1000; i++) {
            final int seed = 34728 + 17 * i;
            GameRunner.run(new Random(seed));
        }
    }
}
