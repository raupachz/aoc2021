package io.raupach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Arrays.*;

public class AdventOfCode01a {

    /**
     * Counts the number of times a depth measurement increases from the previous measurement.
     *
     * @param measurements an array of integer measurements
     * @return  the number of times a depth measurement increased.
     */
    public int depthMeasureIncreasement(int[] measurements) {
        int n = 0;
        for (int i = 1; i < measurements.length; i++) {
            if (measurements[i] > measurements[i - 1]) {
                n++;
            }
        }
        return n;
    }

    public int depthMeasureIncreasement(String[] measurements) {
        int[] _measurements = stream(measurements)
                .mapToInt(Integer::parseInt)
                .toArray();
        return depthMeasureIncreasement(_measurements);
    }

    public int depthMeasureIncreasement(Path path) {
        try {
            String[] measurements = Files.readAllLines(path).toArray(new String[0]);
            return depthMeasureIncreasement(measurements);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources","aoc2021_01a.txt");
        AdventOfCode01a code = new AdventOfCode01a();
        int increases = code.depthMeasureIncreasement(path);
        System.out.println("increases = " + increases);
    }
}
