package io.raupach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.System.*;

public class AdventOfCode06a {

    public int lanternfish(String[] input, int days) {
        String line = input[0];
        String[] tokens = line.split(",");
        int[] fish = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            fish[i] = Integer.parseInt(tokens[i]);
        }

        // Done loading now we run days
        while (days-- > 0) {
            int spawns = 0;
            for (int i = 0; i < fish.length; i++) {
                int age = fish[i];
                if (age == 0) {
                    fish[i] = 6;
                    spawns++;
                } else {
                    fish[i] = fish[i] - 1;
                }
            }
            if (spawns > 0) {
                int[] new_fish = new int[fish.length + spawns];
                arraycopy(fish, 0, new_fish, 0, fish.length);
                for (int i = fish.length; i < new_fish.length; i++) {
                    new_fish[i] = 8;
                }
                fish = new_fish;
            }
        }

        return fish.length;
    }

    public int lanternfish(Path path, int days) {
        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);
            return lanternfish(lines, days);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources","aoc2021_06.txt");
        AdventOfCode06a code = new AdventOfCode06a();
        int lanternfish = code.lanternfish(path, 80);
        out.println("lanternfish = " + lanternfish);
    }

}
