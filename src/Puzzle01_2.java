import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Puzzle01_2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\input01.txt"))) {
            String line;
            String fixLine;
            int finalResult = 0;
            while ((line = br.readLine()) != null) {
                fixLine = line.replace("one", "1")
                        .replace("two", "2")
                        .replace("three", "3")
                        .replace("four", "4")
                        .replace("five", "5")
                        .replace("six", "6")
                        .replace("seven", "7")
                        .replace("eight", "8")
                        .replace("nine", "9");

                fixLine.toCharArray();
                char first = 0;
                char last = 0;
                String result;
                for (int i = 0; i < fixLine.length(); i++) {
                    if (fixLine.charAt(i) > 47 && fixLine.charAt(i) < 58) {
                        first = fixLine.charAt(i);
                        System.out.println(fixLine);
                        System.out.println(first);
                        break;
                    }
                }

                for (int j = fixLine.length() - 1; j >= 0; j--) {
                    if (fixLine.charAt(j) > 47 && fixLine.charAt(j) < 58) {
                        last = fixLine.charAt(j);
                        System.out.println(last);
                        break;
                    }
                }

                result = Character.toString(first) + Character.toString(last);
                finalResult += Integer.parseInt(result);
                System.out.println(finalResult);
            }
        }
        catch (
    FileNotFoundException ex) {
        throw new RuntimeException(ex);
    }
        catch (IOException ex) {
        throw new RuntimeException(ex);
    }

    }
}
