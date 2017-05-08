package com.workshop.refactoring;

import org.junit.Test;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GoldenMasterTests {

    private final Path actualPath = Paths.get("output.log");
    private final Path goldenMasterPath = Paths.get("golden-master.txt");

    @Test
    public void runGame() throws Exception {
        System.setOut(new PrintStream(actualPath.toFile()));
        for (int i = 0; i < 1000; i++) {
            final int seed = 34728 + 17 * i;
            GameRunner.run(new Random(seed));
        }

        final String actual = String.valueOf(Files.readAllLines(actualPath));
        final String expected = String.valueOf(Files.readAllLines(goldenMasterPath));

        assertThat(actual, is(expected));
    }
}
