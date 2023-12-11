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
            temp.removeAll(Arrays.asList("", null));
            String[] list = temp.toArray(new String[0]);
            int[] seeds = new int[0];
            int[] seedToSoil = new int[0];
            List<String> map1 = new ArrayList<>();


            for (int i = 0; i < list.length; i++) {
                if (list[i].contains("seeds:")) {
                    seeds = Arrays.stream(list[i + 1].split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    break;
                }
            }

            for (int a = 0; a < seeds.length; a++) {
                for (int j = 0; j < list.length + 1; j++) {
                    if (list[j].contains("seed-to-soil map:")) {
                        int i = 1;
                        while (!list[j + i].contains("map")) {
                            map1.add(list[j + i]);
                            for (int k = 0; k < map1.size(); k++) {
                                String[] xy = map1.get(k).split(" ");
                                if (seeds[a] >= Integer.parseInt(xy[1]) && seeds[a] < (Integer.parseInt(xy[1]) + Integer.parseInt(xy[2]))) {
                                    seeds[a] = (seeds[a] + Integer.parseInt(xy[0]) - Integer.parseInt(xy[1]));
                                    break;
                                }
                            }
                            i++;
                        }

                        while (!list[j + i].contains("map")) {
                            map1.add(list[j + i]);
                            for (int k = 0; k < map1.size(); k++) {
                                String[] xy = map1.get(k).split(" ");
                                if (seeds[a] >= Integer.parseInt(xy[1]) && seeds[a] < (Integer.parseInt(xy[1]) + Integer.parseInt(xy[2]))) {
                                    seeds[a] = (seeds[a] + Integer.parseInt(xy[0]) - Integer.parseInt(xy[1]));
                                    break;
                                }
                            }
                            i++;
                        }
                        while (!list[j + i].contains("map")) {
                            map1.add(list[j + i]);
                            for (int k = 0; k < map1.size(); k++) {
                                String[] xy = map1.get(k).split(" ");
                                if (seeds[a] >= Integer.parseInt(xy[1]) && seeds[a] < (Integer.parseInt(xy[1]) + Integer.parseInt(xy[2]))) {
                                    seeds[a] = (seeds[a] + Integer.parseInt(xy[0]) - Integer.parseInt(xy[1]));
                                    break;
                                }
                            }
                            i++;
                        }
                        while (!list[j + i].contains("map")) {
                            map1.add(list[j + i]);
                            for (int k = 0; k < map1.size(); k++) {
                                String[] xy = map1.get(k).split(" ");
                                if (seeds[a] >= Integer.parseInt(xy[1]) && seeds[a] < (Integer.parseInt(xy[1]) + Integer.parseInt(xy[2]))) {
                                    seeds[a] = (seeds[a] + Integer.parseInt(xy[0]) - Integer.parseInt(xy[1]));
                                    break;
                                }
                            }
                            i++;
                        }
                        while (!list[j + i].contains("map")) {
                            map1.add(list[j + i]);
                            for (int k = 0; k < map1.size(); k++) {
                                String[] xy = map1.get(k).split(" ");
                                if (seeds[a] >= Integer.parseInt(xy[1]) && seeds[a] < (Integer.parseInt(xy[1]) + Integer.parseInt(xy[2]))) {
                                    seeds[a] = (seeds[a] + Integer.parseInt(xy[0]) - Integer.parseInt(xy[1]));
                                    break;
                                }
                            }
                            i++;
                        }
                        while (!list[j + i].contains("map")) {
                            map1.add(list[j + i]);
                            for (int k = 0; k < map1.size(); k++) {
                                String[] xy = map1.get(k).split(" ");
                                if (seeds[a] >= Integer.parseInt(xy[1]) && seeds[a] < (Integer.parseInt(xy[1]) + Integer.parseInt(xy[2]))) {
                                    seeds[a] = (seeds[a] + Integer.parseInt(xy[0]) - Integer.parseInt(xy[1]));
                                    break;
                                }
                            }
                            i++;
                        }
                        while (!list[j + i].contains("map")) {
                            map1.add(list[j + i]);
                            for (int k = 0; k < map1.size(); k++) {
                                String[] xy = map1.get(k).split(" ");
                                if (seeds[a] >= Integer.parseInt(xy[1]) && seeds[a] < (Integer.parseInt(xy[1]) + Integer.parseInt(xy[2]))) {
                                    seeds[a] = (seeds[a] + Integer.parseInt(xy[0]) - Integer.parseInt(xy[1]));
                                    break;
                                }
                            }
                            i++;
                        }

                    }

                    }
                System.out.println(seeds[a]);
            }



            System.out.println(Arrays.toString(seeds));
            System.out.println(Arrays.toString(seedToSoil));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}