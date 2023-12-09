package Puzzle05;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class Puzzle05 {
        public static void main(String[] args) {
            Path path = Path.of("src\\Puzzle05\\input05.txt");
            try {
                String[] list = Files.readAllLines(path).toArray(new String[0]);
                int[] seeds = new int[0];
                int[] seedToSoil = new int[0];
                for (int i = 0; i < list.length; i++) {
                    if (list[i].contains("seeds:")) {
                        seeds = Arrays.stream(list[i + 1].split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();

                    } else if (list[i].contains("seed-to-soil map:")) {
                        for (int j = 1; j < list.length+1; j++) {
                            if (!list[i].equals(null)) {
                                seedToSoil = Arrays.stream(list[i + j].split(" "))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();
                            }
                            else break;
                        }
                    }

                }
                System.out.println(Arrays.toString(seeds));
                System.out.println(Arrays.toString(seedToSoil));

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
