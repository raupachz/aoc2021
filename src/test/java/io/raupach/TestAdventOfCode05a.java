package io.raupach;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode05a {

    @Test
    public void testHydrothermalVents() {
        Path path = Paths.get("src/test/resources", "aoc2021_05.txt");
        int expected = 5;
        int actual   = new AdventOfCode05a().hydrothermalVents(path);
        assertEquals(expected, actual);
    }

}
