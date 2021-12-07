package io.raupach;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode04a {

    @Test
    public void testBingo() {
        Path path = Paths.get("src/test/resources", "aoc2021_04.txt");
        int expected = 4512;
        int actual   = new AdventOfCode04a().bingo(path);
        assertEquals(expected, actual);
    }

}
