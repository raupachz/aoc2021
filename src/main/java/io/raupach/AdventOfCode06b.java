package io.raupach;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.System.arraycopy;
import static java.lang.System.out;

public class AdventOfCode06b {

    public long lanternfish(String[] input, int days) {
        // Initial data
        String line = input[0];
        String[] tokens = line.split(",");

        long fish = 0L;

        // Problem: Huge Memory needed and Java Arrays length is an int.
        // Looks like it won't fit into memory, how about a file?
        // We can count with a long instead of an int.
        File tape = new File("src/main/resources", "memory.bin");
        if (tape.exists()) {
            tape.delete();
        }

        try {
            RandomAccessFile mem = new RandomAccessFile(tape, "rw");
            // load initial fish into file
            for (String token : tokens) {
                int age = Integer.parseInt(token);
                mem.writeByte(age);
                fish++;
            }

            int n = days;
            while (n-- > 0) {
                System.out.println("Day " + (days - n));
                // rewind memory
                mem.seek(0);
                // new fish to spawn
                int spawns = 0;

                for (long i = 0; i < fish; i++) {
                    long pos = mem.getFilePointer();
                    int age = mem.readByte();
                    if (age == 0) {
                        age = 6;
                        spawns++;
                    } else {
                        age = age - 1;
                    }
                    mem.seek(pos);
                    mem.writeByte(age);
                }
                if (spawns > 0) {
                    for (int i = 0; i < spawns; i++) {
                        mem.writeByte(8);
                    }
                    fish = fish + spawns;
                }
            }
            mem.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fish;
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
