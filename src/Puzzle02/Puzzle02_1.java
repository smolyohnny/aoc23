package Puzzle02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Puzzle02_1 {
    public static void main(String[] args) {
        Path path = Path.of("src\\Puzzle02\\input02.txt");
        try{
            List <String> strings = Files.readAllLines(path);
            int finalResult = 0;
            int powerResult = 0;
            for (String line : strings) {
                String replaced = line.replace("Game ", "");
                String[] noIDs = replaced.split(": ");
                String[] noSemi = noIDs[1].split("; ");
                int r = 0;
                int g = 0;
                int b = 0;

                for (int i = 0; i < noSemi.length; i++) {
                    String[] ind = noSemi[i].split(", ");
                    for (int j = 0; j < ind.length; j++) {
                        if (ind[j].contains("red") && r < Integer.parseInt(ind[j].replace(" red", ""))) r = Integer.parseInt(ind[j].replace(" red", ""));
                        if (ind[j].contains("green") && g < Integer.parseInt(ind[j].replace(" green", ""))) g = Integer.parseInt(ind[j].replace(" green", ""));
                        if (ind[j].contains("blue") && b < Integer.parseInt(ind[j].replace(" blue", ""))) b = Integer.parseInt(ind[j].replace(" blue", ""));
                    }
                }
                int linePower = r * g * b;
                powerResult += linePower;
                if (r <= 12 && g <= 13 && b <= 14) finalResult += Integer.parseInt(noIDs[0]);
                System.out.println(noIDs[0] + " " + finalResult);
            }
            System.out.println(finalResult);
            System.out.println(powerResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
