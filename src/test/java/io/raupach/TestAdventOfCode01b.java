package io.raupach;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode01b {

    @Test
    public void testDepthMeasureIncreasement() {
        Path path = Paths.get("src/test/resources", "aoc2021_01b.txt");
        int expected = 5;
        int actual   = new AdventOfCode01b().depthMeasureIncreasement(path);
        assertEquals(expected, actual);
    }

}
