package io.raupach;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode02a {

    @Test
    public void testNavigate() {
        Path path = Paths.get("src/test/resources", "aoc2021_02.txt");
        int expected = 150;
        int actual   = new AdventOfCode02a().navigate(path);
        assertEquals(expected, actual);
    }

}
