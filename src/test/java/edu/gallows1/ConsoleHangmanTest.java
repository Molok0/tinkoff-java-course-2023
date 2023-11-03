package edu.gallows1;

import edu.gallows1.DictionaryModel.GallowsDictionary;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConsoleHangmanTest {

    @Test
    void testThatGameProgress() {
        List<String> gameProgress = new ArrayList<>();
        gameProgress.add("Guess a letter:");
        gameProgress.add("Missed, mistake 1 out of 5.");
        gameProgress.add("The word: ****");
        gameProgress.add("Guess a letter:");
        gameProgress.add("Hit!");
        gameProgress.add("The word: t***");
        gameProgress.add("Guess a letter:");
        gameProgress.add("Hit!");
        gameProgress.add("The word: ty**");
        gameProgress.add("Guess a letter:");
        gameProgress.add("Hit!");
        gameProgress.add("The word: typ*");
        gameProgress.add("Guess a letter:");
        gameProgress.add("Win!");
        gameProgress.add("The word: type");

        List<String> input = new ArrayList<>();
        input.add("w");
        input.add("t");
        input.add("y");
        input.add("p");
        input.add("e");

        ByteArrayInputStream byteArrayInputStream =
            new ByteArrayInputStream(String.join(System.lineSeparator(), input).getBytes());

        String[] words = new String[] {"type"};
        ConsoleHangman consoleHangman =
            new ConsoleHangman(new Session(5, words));
        consoleHangman.setScanner(byteArrayInputStream);
        consoleHangman.run();
        assertThat(consoleHangman.getGameProgress()).isEqualTo(gameProgress);
    }

    @Test
    void testThatLoseGame() {
        List<String> gameProgress = new ArrayList<>();
        gameProgress.add("Guess a letter:");
        gameProgress.add("Missed, mistake 1 out of 5.");
        gameProgress.add("The word: ****");
        gameProgress.add("Guess a letter:");
        gameProgress.add("Missed, mistake 2 out of 5.");
        gameProgress.add("The word: ****");
        gameProgress.add("Guess a letter:");
        gameProgress.add("Missed, mistake 3 out of 5.");
        gameProgress.add("The word: ****");
        gameProgress.add("Guess a letter:");
        gameProgress.add("Missed, mistake 4 out of 5.");
        gameProgress.add("The word: ****");
        gameProgress.add("Guess a letter:");
        gameProgress.add("Lose!");
        gameProgress.add("The word: ****");

        List<String> input = new ArrayList<>();
        input.add("w");
        input.add("a");
        input.add("c");
        input.add("b");
        input.add("o");

        ByteArrayInputStream byteArrayInputStream =
            new ByteArrayInputStream(String.join(System.lineSeparator(), input).getBytes());

        String[] words = new String[] {"type"};
        ConsoleHangman consoleHangman =
            new ConsoleHangman(new Session(5, words));
        consoleHangman.setScanner(byteArrayInputStream);
        consoleHangman.run();
        assertThat(consoleHangman.getGameProgress()).isEqualTo(gameProgress);
    }
}
