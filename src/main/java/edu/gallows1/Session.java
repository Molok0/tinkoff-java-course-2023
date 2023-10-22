package edu.gallows1;

import edu.gallows.DictionaryModel.GallowsDictionary;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.Formatter;

class Session {
    public static final String winMassage = "Win!";
    public static final String loseMassage = "Lose!";
    public static final String hitMassage = "Hit!";
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    Session(int maxAttempts, String[] words) {
        GallowsDictionary gallowsDictionary = new GallowsDictionary();
        this.answer = gallowsDictionary.randomWord(words);
        this.userAnswer = initUserAnswer(answer);
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    private char[] initUserAnswer(String answer) {
        char[] newUserAnswer = new char[answer.length()];
        Arrays.fill(newUserAnswer, '*');
        return newUserAnswer;
    }

    @NotNull GuessResult guess(char guess) {
        if (letterInAnswer(guess)) {
            if (winGame(guess)) {
                return new GuessResult.Win(new String(this.userAnswer), attempts, winMassage);
            }
            return new GuessResult.SuccessfulGuess(new String(this.userAnswer), attempts, hitMassage);
        }
        attempts += 1;
        if (attempts == maxAttempts) {
            return giveUp();
        }
        Formatter formatter = new Formatter();
        formatter.format("Missed, mistake %s out of %d.", attempts, maxAttempts);
        return new GuessResult.FailedGuess(new String(this.userAnswer), attempts, formatter.toString());
    }

    private void changeUserAnswer(char guess) {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
            }
        }
    }

    private boolean winGame(char guess) {
        changeUserAnswer(guess);
        return answer.equals(new String(userAnswer));
    }

    private boolean letterInAnswer(char guess) {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                return true;
            }
        }
        return false;
    }

    @NotNull GuessResult giveUp() {
        return new GuessResult.Defeat(new String(this.userAnswer), attempts, loseMassage);
    }
}
