package edu.hw1;

public class Task4 {

    public static String fixString(String wrongString) {
        char[] answer = wrongString.toCharArray();
        char tmp;

        for (int i = 0; i < answer.length - 1; i += 2) {
            tmp = answer[i];
            answer[i] = answer[i + 1];
            answer[i + 1] = tmp;
        }
        return new String(answer);
    }
}
