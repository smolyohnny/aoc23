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

            for (int i = 0; i < list.length; i++) {
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

                while (j != 258) {
                    String[] xy = list[j].split(" ");
                    if (seeds[a] >= Long.parseLong(xy[1]) && seeds[a] < (Long.parseLong(xy[1]) + Long.parseLong(xy[2]))) {
                        seeds[a] = (seeds[a] + Long.parseLong(xy[0]) - Long.parseLong(xy[1]));
                    }
                    j++;
                }
            }
            System.out.println(Arrays.toString(seeds));

            long min = seeds[0];
            //Loop through the array
            for (int i = 0; i < seeds.length; i++) {
                //Compare elements of array with min
                if(seeds[i] <min)
                    min = seeds[i];
            }

            System.out.println(min  );


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}