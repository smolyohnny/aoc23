import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Puzzle01_1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src\\input01.txt"))) {
            String line;
            int finalResult = 0;
            while ((line = br.readLine()) != null) {
                line.toCharArray();
                char first = 0;
                char last = 0;
                String result;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) > 47 && line.charAt(i) < 58) {
                        first = line.charAt(i);
                        break;
                    }
                }

                for (int j = line.length() - 1; j >= 0; j--) {
                    if (line.charAt(j) > 47 && line.charAt(j) < 58) {
                        last = line.charAt(j);
                        break;
                    }
                }

                result = Character.toString(first) + Character.toString(last);
                finalResult += Integer.parseInt(result);
                System.out.println(finalResult);
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

