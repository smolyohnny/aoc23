import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Puzzle01_2 {
    public static void main(String[] args) {
        Path path = Path.of("src\\input01.txt");
        try {
            List<String> strings = Files.readAllLines(path);
            int finalResult = 0;
            for (String line : strings) {
                String leftNum = "";
                int index = 0;
                while (leftNum.isEmpty()) {
                    String s = line.substring(0, index);
                    leftNum = findNum(line.substring(0, index));
                    index++;
                }
                String rightNum = "";
                index = 0;
                while (rightNum.isEmpty()) {
                    rightNum = findNum(line.substring(line.length() - index, line.length()));
                    index++;
                }

                int result = Integer.parseInt(leftNum + rightNum);
                finalResult += result;
                System.out.println(finalResult);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String findNum(String subString) {
        subString = subString.replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")
                .replaceAll("[^\\d.]", "");
        return subString;
    }
}
