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
            List<String> strings = Files.readAllLines(path);
            int[] matches = new int[214];
            int[] clonMatches = new int[matches.length];
            for (String before : strings) {
                int matchCount = 0;
                String after = before.trim().replaceAll(" +", " ");
                String[] strings2 = after.split("\\|");
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
                                matchCount++;
                                if (result > 0) {
                                    result *= 2;
                                } else result += 1;
                            }
                        }
                    }
                    finalResult += result;
                    int num = strings.indexOf(before);
                    matches[num] = matchCount;
                }

            for (int i = 0; i < matches.length; i++) {
                clonMatches[i] = matches[i];
            }
            int[] cardCound = new int[matches.length];
            for (int i = 0; i < cardCound.length; i++) {
                cardCound[i] = 1;
            }
            int totalCards = 0;
            for (int k = 0; k < matches.length; k++) {
                for (int i = 1; i < matches[k] + 1; i++) {
                    cardCound[k]++;
                    clonMatches[k + i] += matches[k + i] * cardCound[k + i];
                }
            }
            for (int i = 0; i < 6; i++) {
                totalCards += cardCound[i];
            }
            int totalMatches = 0;
            int totalClonMatches = 0;
            for (int i = 0; i < matches.length; i++) {
                totalMatches += matches[i];
            }
            for (int i = 0; i <clonMatches.length; i++) {
                totalClonMatches += clonMatches[i];
            }
            System.out.println(totalCards);
            System.out.println(totalMatches);
            System.out.println(totalClonMatches);
            System.out.println(finalResult);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

