package Puzzle03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Puzzle03 {
    public static void main(String[] args) {

        Path path = Path.of("src\\Puzzle03\\input03.txt");
        try {
            List<String> strings = Files.readAllLines(path);
            int sum = 0;
            int num = 0;
            boolean valid = false;
            int lineNum;
            int position = 0;

            for (String line : strings) {
                lineNum = strings.indexOf(line); //možná + 1 idk
                String lineUp = "............................................................................................................................................";
                String lineDown = "............................................................................................................................................";
                for (int i = 0; i < line.length(); i++) {
                    char character = line.charAt(i);
                    if (Character.isDigit(character)) {
                        num = (num * 10) + Character.getNumericValue(character);
                        position = i;
                        if (lineNum != 0) {
                            lineUp = strings.get(lineNum - 1);
                        }
                        if (lineNum != strings.size() - 1) {
                            lineDown = strings.get(lineNum + 1);
                        }
                        if (isValid(lineUp, strings.get(lineNum), lineDown, position)) valid = true;
                    }
                    if (!Character.isDigit(character)) {
                        if(valid){
                            System.out.println(num);
                            sum += num;}
                        num = 0;
                        valid = false;

                    }
                }
            }
            System.out.println(sum);
        }

        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static boolean isValid(String lineUp, String lineMid, String lineDown, int position) throws IOException {
        if (position != 0) {
            if (lineMid.charAt(position - 1) != '.' && !Character.isDigit(lineMid.charAt(position - 1))) return true;
            if (lineUp.charAt(position - 1) != '.' && !Character.isDigit(lineUp.charAt(position - 1))) return true;
            if (lineDown.charAt(position - 1) != '.' && !Character.isDigit(lineUp.charAt(position - 1))) return true;
        }
        if (position != 139) {
            if (lineMid.charAt(position + 1) != '.' && !Character.isDigit(lineMid.charAt(position + 1))) return true;
            if (lineUp.charAt(position + 1) != '.' && !Character.isDigit(lineUp.charAt(position + 1))) return true;
            if (lineDown.charAt(position + 1) != '.' && !Character.isDigit(lineUp.charAt(position + 1))) return true;
        }
        if (lineUp.charAt(position) != '.' && !Character.isDigit(lineUp.charAt(position))) return true;
        if (lineDown.charAt(position) != '.' && !Character.isDigit(lineUp.charAt(position))) return true;

        else return false;
    }
}
