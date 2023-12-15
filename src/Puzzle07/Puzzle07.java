package Puzzle07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Puzzle07 {
    public static void main(String[] args) throws IOException {
        //this one tickles my gambling addiction
        //https://stackoverflow.com/questions/15452429/java-arrays-sort-2d-array
        Path path = Path.of("src\\Puzzle07\\input07.txt");
        List<String> list = Files.readAllLines(path);


    }
}
