package io.raupach;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode02b {

    @Test
    public void testNavigate() {
        Path path = Paths.get("src/test/resources", "aoc2021_02.txt");
        int expected = 900;
        int actual   = new AdventOfCode02b().navigate(path);
        assertEquals(expected, actual);
    }

}
