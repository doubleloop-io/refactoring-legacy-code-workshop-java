package com.workshop.refactoring;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
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
        runMultipleGames();
        assertThat(readOutput(), is(readGoldenMaster()));
    }

    private void runMultipleGames() throws FileNotFoundException {
        final PrintStream original = System.out;
        try(final PrintStream out = new PrintStream(actualPath.toFile())) {
            System.setOut(out);
            for (int i = 0; i < 1000; i++) {
                final int seed = 34728 + 17 * i;
                GameRunner.run(new Random(seed));
            }
        }
        finally {
           System.setOut(original);
        }
    }

    private String readGoldenMaster() throws IOException {
        return readContent(goldenMasterPath);
    }

    private String readOutput() throws IOException {
        return readContent(actualPath);
    }

    private String readContent(Path path) throws IOException {
        return String.valueOf(Files.readAllLines(path));
    }
}
