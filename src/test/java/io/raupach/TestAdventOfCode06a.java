package io.raupach;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode06a {

    @Test
    public void testLanternfish() {
        Path path = Paths.get("src/test/resources", "aoc2021_06.txt");
        int expected = 5934;
        int actual   = new AdventOfCode06a().lanternfish(path, 80);
        assertEquals(expected, actual);
    }

}
