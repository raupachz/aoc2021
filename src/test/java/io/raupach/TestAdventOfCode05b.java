package io.raupach;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode05b {

    @Test
    public void testHydrothermalVents() {
        Path path = Paths.get("src/test/resources", "aoc2021_05.txt");
        int expected = 12;
        int actual   = new AdventOfCode05b().hydrothermalVents(path);
        assertEquals(expected, actual);
    }

}
