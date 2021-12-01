package io.raupach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestAdventOfCode01a {

    @Test
    public void testDepthMeasureIncreasement() {
        Path path = Paths.get("src/test/resources", "aoc2021_01a.txt");
        int expected = 7;
        int actual   = new AdventOfCode01a().depthMeasureIncreasement(path);
        assertEquals(expected, actual);
    }

}
