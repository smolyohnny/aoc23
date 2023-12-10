package Puzzle05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Puzzle05 {
    public static void main(String[] args) {
        Path path = Path.of("src\\Puzzle05\\input05.txt");

        try {
            List<String> strings = Files.readAllLines(path);
            for (String before : strings) {
                String after = before.trim().replaceAll(" +", " ");
                System.out.println(after);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
