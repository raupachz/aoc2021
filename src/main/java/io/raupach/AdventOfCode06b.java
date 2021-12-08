package io.raupach;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.*;

public class AdventOfCode06b {

    public long lanternfish(String[] input, int days) {
        // Initial data
        String line = input[0];
        String[] tokens = line.split(",");

        // We do no care about the position of the fishy. All we need to track is the
        // total numbers of fish 8 years old, of fish 6 years old...
        long[] fish = new long[9];

        // Load inital data
        for (int i = 0; i < tokens.length; i++) {
            int index = Integer.parseInt(tokens[i]);
            fish[index] = fish[index] + 1;
        }

        while (days-- > 0) {
            long n = fish[0];
            fish[0] = fish[1];
            fish[1] = fish[2];
            fish[2] = fish[3];
            fish[3] = fish[4];
            fish[4] = fish[5];
            fish[5] = fish[6];
            fish[6] = fish[7];
            fish[7] = fish[8];

            fish[6] = fish[6] + n;
            fish[8] = n;
        }

        // Total number is the number of fish in each age group
        long n = 0;
        for (int i = 0; i < fish.length; i++) {
            n += fish[i];
        }
        return n;
    }

    public long lanternfish(Path path, int days) {
        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);
            return lanternfish(lines, days);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources","aoc2021_06.txt");
        AdventOfCode06b code = new AdventOfCode06b();
        long lanternfish = code.lanternfish(path, 256);
        out.println("lanternfish = " + lanternfish);
    }

}
