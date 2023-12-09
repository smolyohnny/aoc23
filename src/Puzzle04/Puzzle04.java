package Puzzle04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Puzzle04 {
    public static void main(String[] args) {
        Path path = Path.of("src\\Puzzle04\\input04.txt");
        try {
            int finalResult = 0;
            int finalCardCount = 0;
            int[] cardCount = new int[214];
            int[] matchCount = new int[214];
            List<String> strings = Files.readAllLines(path);
            for (String list : strings) {
                int counter = 0;
                String awawa = list.trim().replaceAll(" +", " ");

                String[] strings2 = awawa.split("\\|");

                String[] winNums = strings2[0].replace("Card ", "").replace(":", "").split(" ");

                String[] myNums = strings2[1].split(" ");

                List<String> my = new ArrayList<>();

                for (String s : myNums) {
                    if(s != null && s.length() > 0) {
                        my.add(s);
                    }
                }

                myNums = my.toArray(new String[my.size()]);
                List<String> win = new ArrayList<String>();

                for(String s : winNums) {
                    if(s != null && s.length() > 0) {
                        win.add(s);
                    }
                }

                winNums = win.toArray(new String[win.size()]);
                int[] winArr = new int[winNums.length];

                for (int i = 0; i < winArr.length; i++) {
                    if (winNums[i] != null) winArr[i] = Integer.parseInt(winNums[i]);
                }

                int[] myArr = new int[myNums.length];

                for (int i = 0; i < myArr.length; i++) {
                    if (myNums[i] != null) {
                        myArr[i] = Integer.parseInt(myNums[i]);
                    }
                }
                    int result = 0;

                    for (int i = 1; i < winArr.length; i++) {
                        for (int j = 0; j < myArr.length; j++) {
                            if (winArr[i] == myArr[j]) {
                                counter++;
                                if (result > 0) {
                                    result *= 2;
                                } else result += 1;
                            }
                        }
                    }

                    finalResult += result;
                    matchCount[strings.indexOf(list)] = counter;

                }
            System.out.println(Arrays.toString(matchCount));
            for (int i = 0; i < cardCount.length; i++) {
                cardCount[i] = 1;
            }
            for (int i = 0; i < cardCount.length; i++) {
                for (int j = 1; j < matchCount[i] + 1; j++) {
                    cardCount[i + j] += cardCount[i];
                }
                finalCardCount += cardCount[i];
            }

            System.out.println(Arrays.toString(cardCount));
            System.out.println(finalCardCount);
            System.out.println(finalResult);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
