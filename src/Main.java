import com.sun.jdi.Value;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\janha\\IdeaProjects\\aoc\\src\\input.txt"))) {
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

