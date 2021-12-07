package io.raupach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static java.lang.Math.*;

public class AdventOfCode05a {

    public int hydrothermalVents(String[] args) {
        List<Line> lines = new ArrayList<>();
        // Parse
        for (String arg : args) {
            var line = parse(arg);
            lines.add(line);
        }

        // Find dimensions of map
        int rows    = rows(lines);
        int columns = columns(lines);

        // initialize blank map
        int[][] map = map(rows, columns);

        // draw lines
        //print(map);
        //System.out.println();

        for (Line line : lines) {
            draw(map, line);
            //print(map);
            //System.out.println();
        }

        int cnt = count(map);
        
        return cnt;
    }

    public int hydrothermalVents(Path path) {
        try {
            String[] lines = Files.readAllLines(path).toArray(new String[0]);
            return hydrothermalVents(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Path path = Paths.get("src/main/resources","aoc2021_05.txt");
        AdventOfCode05a code = new AdventOfCode05a();
        int vents = code.hydrothermalVents(path);
        System.out.println("vents = " + vents);
    }

    // ---- Helper methods

    int rows(List<Line> lines) {
        // 3,7 and 5,4 then we have at least 7 rows
        int y = 0;
        for (Line line : lines) {
            int n = Math.max(line.a.y, line.b.y);
            if (n > y) {
                y = n;
            }
        }
        return y + 1;
    }

    int columns(List<Line> lines) {
        // 3,7 and 5,4 then we have at least 5 rows
        int x = 0;
        for (Line line : lines) {
            int n = Math.max(line.a.x, line.b.x);
            if (n > x) {
                x = n;
            }
        }
        return x + 1;
    }

    int[][] map(int rows, int columns) {
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = 0;
            }
        }
        return map;
    }

    void draw(int[][] map, Line line) {
        int rows    = map.length;
        int columns = map[0].length;

        // vertical match, same column, iterate over rows
        // (1,4) -> (1,9)
        if (line.a.x == line.b.x) {
            int i = min(line.a.y, line.b.y);
            int j = max(line.a.y, line.b.y);
            for (; i <= j; i++) {
                int n = map[i][line.a.x];
                n++;
                map[i][line.a.x] = n;
            }
        } else if (line.a.y == line.b.y) {
            // horizontal match, same row, iterate over columns
            // 0,9 -> 5,9
            // row 9 from 0 to 5
            int i = min(line.a.x, line.b.x);
            int j = max(line.a.x, line.b.x);
            for (; i <= j; i++) {
                int n = map[line.a.y][i];
                n++;
                map[line.a.y][i] = n;
            }
        } else {
            ;
        }

        // diagonal

    }

    void print(int[][] map) {
        int rows    = map.length;
        int columns = map[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int n = map[i][j];
                if (n == 0) {
                    System.out.print('.');
                } else {
                    System.out.print(n);
                }
            }
            System.out.println();
        }
    }

    int count(int[][] map) {
        int rows    = map.length;
        int columns = map[0].length;
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (map[i][j] > 1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // ---- Helper classes

    Line parse(String s) { // z.B. 0,0 -> 8,8
        String[] tokens = s.split(" -> ");
        String a = tokens[0];
        String b = tokens[1];

        String[] x = a.split(",");
        String[] y = b.split(",");

        Point point1 = new Point(
                Integer.parseInt(x[0]),
                Integer.parseInt(x[1])
        );

        Point point2 = new Point(
                Integer.parseInt(y[0]),
                Integer.parseInt(y[1])
        );

        return new Line(point1, point2);
    }


    class Line {
        final Point a,b;

        public Line(Point a, Point b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append(a)
                    .append(" -> ")
                    .append(b)
                    .toString();
        }
    }

    class Point {
        final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return new StringBuilder()
                    .append(x)
                    .append(',')
                    .append(y)
                    .toString();
        }
    }

}
