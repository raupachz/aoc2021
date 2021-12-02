package io.raupach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdventOfCode02b {

    public int navigate(String[] commands) {
        int depth = 0, horizontal = 0, aim = 0;

        for (String command : commands) {
            var direction = command.substring(0, command.indexOf(' '));
            var value = Integer.parseInt(command.substring(command.indexOf(' ') + 1));
            switch (direction) {
                case "up"     : aim -= value;      break;
                case "down"   : aim += value;      break;
                case "forward":
                    horizontal += value;
                    depth += (aim * value);
                    break;
            }
        }

        return depth * horizontal;
    }

    public int navigate(Path path) {
        try {
            String[] commands = Files.readAllLines(path).toArray(new String[0]);
            return navigate(commands);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources","aoc2021_02.txt");
        AdventOfCode02b code = new AdventOfCode02b();
        int destination = code.navigate(path);
        System.out.println("destination = " + destination);
    }

}
