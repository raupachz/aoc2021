package io.raupach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Arrays.stream;

public class AdventOfCode02a {

    public int navigate(String[] commands) {
        int depth = 0, horizontal = 0;

        for (String command : commands) {
            var direction = command.substring(0, command.indexOf(' '));
            var value = Integer.parseInt(command.substring(command.indexOf(' ') + 1));
            switch (direction) {
                case "forward": horizontal += value; break;
                case "up"     : depth -= value;      break;
                case "down"   : depth += value;      break;
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
        AdventOfCode02a code = new AdventOfCode02a();
        int destination = code.navigate(path);
        System.out.println("destination = " + destination);
    }

}
