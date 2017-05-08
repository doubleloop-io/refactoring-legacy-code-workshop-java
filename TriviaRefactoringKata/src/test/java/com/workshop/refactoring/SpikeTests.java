package com.workshop.refactoring;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SpikeTests {
    @Test
    public void runGame() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        GameRunner.main(null);
        assertThat("", is(out.toString()));
    }
}
