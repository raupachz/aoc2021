package io.raupach;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode03b {

    @Test
    public void testLifeSupportRating() {
        Path path = Paths.get("src/test/resources", "aoc2021_03.txt");
        int expected = 230;
        int actual   = new AdventOfCode03b().lifeSupportRating(path, 5);
        assertEquals(expected, actual);
    }

}
