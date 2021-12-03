package io.raupach;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAdventOfCode03a {

    @Test
    public void testPowerConsumption() {
        Path path = Paths.get("src/test/resources", "aoc2021_03.txt");
        int expected = 198;
        int actual   = new AdventOfCode03a().powerConsumption(path, 5);
        assertEquals(expected, actual);
    }

}
