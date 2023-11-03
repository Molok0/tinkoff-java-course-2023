package edu.gallows1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ConsoleHangman {

    private static final String GUESS_MESSAGE = "Guess a letter:";
    private static final String STOP_MESSAGE = "Exit";
    private static final String INVALID_MESSAGE = "Invalid value";
    private final static int MAX_ATTEMPT = 5;
    private final List<String> gameProgress = new ArrayList<>();
    private final static Logger LOGGER = LogManager.getLogger();

    private Session session;
    private Scanner scanner;

    ConsoleHangman(Session session) {
        this.session = session;
    }

    public void run() {

        while (true) {
            gameProgress.add(GUESS_MESSAGE);
            LOGGER.info(GUESS_MESSAGE);
            var input = scanner.nextLine();

            if (input.equals(STOP_MESSAGE)) {
                break;
            }

            if (input.length() != 1) {
                gameProgress.add(INVALID_MESSAGE);
                LOGGER.info(INVALID_MESSAGE);
                continue;
            }

            GuessResult guessResult = tryGuess(this.session, input);
            printState(guessResult);
            // Конец игры при победе или поражении

            if (guessResult instanceof GuessResult.Win || guessResult instanceof GuessResult.Defeat) {
                break;
            }
        }
    }

    public List<String> getGameProgress() {
        return gameProgress;
    }

    private GuessResult tryGuess(Session session, String input) {
        return session.guess(input.charAt(0));
    }

    private void printState(GuessResult guess) {
        gameProgress.add(guess.message());
        gameProgress.add("The word: " + guess.word());
        LOGGER.info(guess.message());
        LOGGER.info("The word:" + guess.word());
    }

    public void setScanner(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public void setScanner() {
        this.scanner = new Scanner(System.in);
    }
}
