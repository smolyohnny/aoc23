package Puzzle05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class Puzzle05 {
    public static void main(String[] args) {
        Path path = Path.of("src\\Puzzle05\\input05.txt");
        try {
            List<String> temp = Files.readAllLines(path);
            String[] list = temp.toArray(new String[0]);
            long[] seeds = new long[0];

            for (int i = 0; i < 4; i++) {
                if (list[i].contains("seeds:")) seeds = Arrays.stream(list[i + 1].split(" ")).mapToLong(Long::parseLong).toArray();
            }


            for (int a = 0; a < seeds.length; a++) {
                int j = 4;
                for (int i = 0; i < 6; i++) {
                    while (!list[j].isBlank()) {
                        String[] xy = list[j].split(" ");
                        if (seeds[a] >= Long.parseLong(xy[1]) && seeds[a] < (Long.parseLong(xy[1]) + Long.parseLong(xy[2]))) {
                            seeds[a] = (seeds[a] + Long.parseLong(xy[0]) - Long.parseLong(xy[1]));
                            while (!list[j].isBlank()) j++;
                        }
                        else j++;
                    }
                    j += 2;
                }

                while (j != 259) {
                    String[] xy = list[j].split(" ");
                    if (seeds[a] >= Long.parseLong(xy[1]) && seeds[a] < (Long.parseLong(xy[1]) + Long.parseLong(xy[2]))) {
                        seeds[a] = (seeds[a] + Long.parseLong(xy[0]) - Long.parseLong(xy[1]));
                    }
                    j++;
                }
            }

            //part2 ________________________________________________________________________________________________________________________

            long allMin = 999999999;
            for (int pair = 0; pair < seeds.length; pair+=2) {
                long[] allSeedsArr = {seeds[pair], seeds[pair+1]};

                for (int a = 0; a < allSeedsArr[0] + allSeedsArr[1]; a++) { //možná -1
                    long current = allSeedsArr[0] + a;
                    int j = 4;
                    for (int i = 0; i < 6; i++) {
                        while (!list[j].isBlank()) {
                            String[] xy = list[j].split(" ");
                            if (current >= Long.parseLong(xy[1]) && current < (Long.parseLong(xy[1]) + Long.parseLong(xy[2]))) {
                                current = (current + Long.parseLong(xy[0]) - Long.parseLong(xy[1]));
                                while (!list[j].isBlank()) j++;
                            } else j++;
                        }
                        j += 2;
                    }

                    while (j != 259) {
                        String[] xy = list[j].split(" ");
                        if (current >= Long.parseLong(xy[1]) && current < (Long.parseLong(xy[1]) + Long.parseLong(xy[2]))) {
                            current = (current + Long.parseLong(xy[0]) - Long.parseLong(xy[1]));
                        }
                        j++;
                    }
                    if (current < allMin) allMin = current;
                }
            }

            System.out.println(Arrays.toString(seeds));

            long min = seeds[0];
            for (int i = 0; i < seeds.length; i++) {
                if(seeds[i] <min) min = seeds[i];
            }

            System.out.println(min);
            System.out.println(allMin);


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}