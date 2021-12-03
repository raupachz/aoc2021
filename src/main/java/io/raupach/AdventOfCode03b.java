package io.raupach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdventOfCode03b {

    // Returns the reports with bit in column
    String[] filter(String[] report, int column, char bit) {
        List<String> filtered = new ArrayList<>();
        for (String bitfield : report) {
            if (bitfield.charAt(column) == bit) {
                filtered.add(bitfield);
            }
        }
        return filtered.toArray(new String[0]);
    }

    char mostCommon(String[] report, int column) {
        int ones = 0;
        for (String bitfield : report) {
            if (bitfield.charAt(column) == '1') {
                ones++;
            }
        }
        int zeroes = report.length - ones;
        return (ones >= zeroes) ? '1' : '0';
    }

    char leastCommon(String[] report, int column) {
        return mostCommon(report, column) == '1' ? '0' : '1';
    }

    public int lifeSupportRating(String[] report, int numBits) {
        String[] copy = Arrays.copyOf(report, report.length);
        int column = 0;
        do {
            char bit = mostCommon(copy, column);
            copy = filter(copy, column, bit);
            column++;
        } while (copy.length > 1);

        int oxygenGeneratorRating = Integer.parseInt(copy[0],2);

        copy = Arrays.copyOf(report, report.length);
        column = 0;
        do {
            char bit = leastCommon(copy, column);
            copy = filter(copy, column, bit);
            column++;
        } while (copy.length > 1);

        int scrubberRating = Integer.parseInt(copy[0],2);

        return oxygenGeneratorRating * scrubberRating;
    }

    public int lifeSupportRating(Path path, int numBits) {
        try {
            String[] report = Files.readAllLines(path).toArray(new String[0]);
            return lifeSupportRating(report, numBits);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources","aoc2021_03.txt");
        AdventOfCode03b code = new AdventOfCode03b();
        int powerConsumption = code.lifeSupportRating(path, 12);
        System.out.println("powerConsumptionpowerConsumption = " + powerConsumption);
    }

}
