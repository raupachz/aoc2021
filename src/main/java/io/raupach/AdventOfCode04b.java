package io.raupach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdventOfCode04b {

    public int bingo(String[] lines) {
        String[] numbers = lines[0].split(",");

        // Newslines are separators.
        List<Board> boards = new ArrayList<>();

        int i = 2;
        while (i < lines.length) {
            Board board = new Board(lines, i);
            boards.add(board);
            i += 6; // one blank line separator
        }

        for (int j = 0; j < numbers.length; j++) {
            var number = numbers[j];
            // Remove until last board wins
            for (Board board : boards) {
                board.mark(number);
            }
            if (boards.size() == 1) {
                var board = boards.get(0);
                if (board.isBingo()) {
                    return board.sumOfUnmarkedNumbers * Integer.valueOf(number);
                }
            } else {
                for (Iterator<Board> iter = boards.listIterator(); iter.hasNext(); ) {
                    var board = iter.next();
                    if (board.isBingo()) {
                        iter.remove();
                    }
                }
            }
        }

        return 0;
    }

    public int bingo(Path path) {
        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);
            return bingo(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources","aoc2021_04.txt");
        AdventOfCode04b code = new AdventOfCode04b();
        int bingo = code.bingo(path);
        System.out.println("bingo = " + bingo);
    }

    class Board {

        int sumOfUnmarkedNumbers;
        int[][] numbers;

        Board(String[] lines, int offset) {
            numbers = new int[5][5];
            for (int i = 0; i < 5; i++) {
                var line = lines[offset + i];
                String[] sNumbers = line.trim().split("\\s+");
                for (int j = 0; j < 5; j++) {
                    numbers[i][j] = Integer.parseInt(sNumbers[j]);
                    sumOfUnmarkedNumbers += numbers[i][j];
                }
            }
        }

        void mark(String number) {
            mark(Integer.parseInt(number));
        }

        void mark(int number) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (numbers[i][j] == number) {
                        sumOfUnmarkedNumbers -= number;
                        numbers[i][j] = -1;
                    }
                }
            }
        }

        boolean isBingo() {
            for (int i = 0; i < 5; i++) {
                var row = numbers[i][0] == -1
                         && numbers[i][1] == -1
                         && numbers[i][2] == -1
                         && numbers[i][3] == -1
                         && numbers[i][4] == -1;
                var column = numbers[0][i] == -1
                        && numbers[1][i] == -1
                        && numbers[2][i] == -1
                        && numbers[3][i] == -1
                        && numbers[4][i] == -1;
                if (row || column) {
                    return true;
                }
            }

            return false;
        }

        public int getSumOfUnmarkedNumbers() {
            return sumOfUnmarkedNumbers;
        }

    }

}
