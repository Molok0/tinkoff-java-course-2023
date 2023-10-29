package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static List<String> clusterize(String setBrackets){
        List<String> answer = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        int ind = 0;
        for (int i = 0; i < setBrackets.length(); i++){
            switch (setBrackets.charAt(i)){
                case '(' -> index.add(i);
                case ')' -> {
                    if (index.isEmpty())
                        continue;
                    index.remove(0);
                    if (index.isEmpty()) {
                        answer.add(setBrackets.substring(ind, i + 1));
                        ind = i + 1;
                    }
                }
            }
        }
        return answer;
    }
}
