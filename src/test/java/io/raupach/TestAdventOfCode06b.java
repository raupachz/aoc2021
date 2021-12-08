package io.raupach;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode06b {

    @Test
    public void testLanternfish() {
        Path path = Paths.get("src/test/resources", "aoc2021_06.txt");
        long expected = 26984457539L;
        long actual   = new AdventOfCode06b().lanternfish(path, 256);
        assertEquals(expected, actual);
    }

}
