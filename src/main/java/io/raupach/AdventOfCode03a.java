package io.raupach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdventOfCode03a {

    public int powerConsumption(String[] report, int numBits) {
        /* I believe there is a smart solution to this problem. */
        StringBuilder mostCommonBit = new StringBuilder(numBits);


        // iterate over each column
        for (int i = 0; i < numBits; i++) {
            int ones = 0;
            for (String bitfield : report) {
                if (bitfield.charAt(i) == '1') {
                    ones++;
                }
            }
            if (ones > report.length / 2) {
                mostCommonBit.append('1');
            } else {
                mostCommonBit.append('0');
            }
        }

        int gamma   = Integer.parseInt(mostCommonBit.toString(),2);

        // ~gamma does not work (well I do not know how)
        StringBuilder flippedBits = new StringBuilder(mostCommonBit.toString());
        for (int i = 0; i < flippedBits.length(); i++) {
            char bit = flippedBits.charAt(i);
            if (bit == '0') {
                flippedBits.setCharAt(i, '1');
            }
            if (bit == '1') {
                flippedBits.setCharAt(i, '0');
            }
        }
        int epsilon = Integer.parseInt(flippedBits.toString(),2);

        // Multiply gamma and epsilon for power consumption
        return gamma * epsilon;
    }

    public int powerConsumption(Path path, int numBits) {
        try {
            String[] report = Files.readAllLines(path).toArray(new String[0]);
            return powerConsumption(report, numBits);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources","aoc2021_03.txt");
        AdventOfCode03a code = new AdventOfCode03a();
        int powerConsumption = code.powerConsumption(path, 12);
        System.out.println("powerConsumptionpowerConsumption = " + powerConsumption);
    }

}
