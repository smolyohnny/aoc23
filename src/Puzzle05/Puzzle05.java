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

            List<Long> startSeeds = new ArrayList<>();
            List<Long> endSeeds = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                if (list[i].contains("seeds:")) seeds = Arrays.stream(list[i + 1].split(" ")).mapToLong(Long::parseLong).toArray();
            }
            for (int j = 0; j < seeds.length; j+=2) {
                startSeeds.add(seeds[j]);
                endSeeds.add(seeds[j + 1]);
            }

            List<Long> allSeeds = new ArrayList<>();
            for (int i = 0; i < seeds.length/2; i ++) {
                long startSeed = startSeeds.get(i);
                long endSeed = endSeeds.get(i);
                for (long j = startSeed; j < startSeed + endSeed; j++) {
                    allSeeds.add(j);
                }
            }

            long[] allSeedsArr = new long[allSeeds.size()];
            for (int i = 0; i < allSeeds.size(); i++) {
                allSeedsArr[i] = allSeeds.get(i);
            }
            System.out.println(allSeedsArr.toString());

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

            //part2
            for (int a = 0; a < allSeedsArr.length; a++) {
                int j = 4;
                for (int i = 0; i < 6; i++) {
                    while (!list[j].isBlank()) {
                        String[] xy = list[j].split(" ");
                        if (allSeedsArr[a] >= Long.parseLong(xy[1]) && allSeedsArr[a] < (Long.parseLong(xy[1]) + Long.parseLong(xy[2]))) {
                            allSeedsArr[a] = (allSeedsArr[a] + Long.parseLong(xy[0]) - Long.parseLong(xy[1]));
                            while (!list[j].isBlank()) j++;
                        }
                        else j++;
                    }
                    j += 2;
                }

                while (j != 259) {
                    String[] xy = list[j].split(" ");
                    if (allSeedsArr[a] >= Long.parseLong(xy[1]) && allSeedsArr[a] < (Long.parseLong(xy[1]) + Long.parseLong(xy[2]))) {
                        allSeedsArr[a] = (allSeedsArr[a] + Long.parseLong(xy[0]) - Long.parseLong(xy[1]));
                    }
                    j++;
                }
            }
            System.out.println(Arrays.toString(seeds));
            System.out.println(Arrays.toString(allSeedsArr));

            long min = seeds[0];
            for (int i = 0; i < seeds.length; i++) {
                if(seeds[i] <min) min = seeds[i];
            }
            long allMin = allSeedsArr[0];
            for (int i = 0; i < allSeedsArr.length; i++) {
                if(allSeedsArr[i] <allMin) allMin = allSeedsArr[i];
            }

            System.out.println(min);
            System.out.println(allMin);


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}