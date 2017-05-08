package com.workshop.refactoring;

import org.junit.Test;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Paths;

public class SpikeTests {
    @Test
    public void runGame() throws Exception {
        File file = Paths.get("output.log").toFile();
        System.setOut(new PrintStream(file));
        final GameRunner runner = new TestableGameRunner();
        runner.run();
    }

    private class TestableGameRunner extends GameRunner {
    }
}
