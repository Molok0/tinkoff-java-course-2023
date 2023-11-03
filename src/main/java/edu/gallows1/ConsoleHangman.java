package edu.gallows1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ConsoleHangman {

    private static final String GUESS_MESSAGE = "Guess a letter:";
    private static final String STOP_MESSAGE = "Exit";
    private static final String INVALID_MESSAGE = "Invalid value";
    private final static int MAX_ATTEMPT = 5;
    private final List<String> GAME_PROGRESS = new ArrayList<String>();

    private Session session;
    private Scanner scanner;

    public static void main(String[] args) {
        String[] words = new String[] {"text", "word", "type"};
        ConsoleHangman consoleHangman =
            new ConsoleHangman(new Session(5, words));
        consoleHangman.setScanner();
        consoleHangman.run();
    }

    ConsoleHangman(Session session) {
        this.session = session;
    }

    public void run() {

        while (true) {
            GAME_PROGRESS.add(GUESS_MESSAGE);
            System.out.println(GUESS_MESSAGE);
            var input = scanner.nextLine();

            if (input.equals(STOP_MESSAGE)) {
                break;
            }

            if (input.length() != 1) {
                GAME_PROGRESS.add(INVALID_MESSAGE);
                System.out.println(INVALID_MESSAGE);
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
        return GAME_PROGRESS;
    }

    private GuessResult tryGuess(Session session, String input) {
        return session.guess(input.charAt(0));
    }

    private void printState(GuessResult guess) {
        GAME_PROGRESS.add(guess.message());
        GAME_PROGRESS.add("The word: " + guess.word());
        System.out.println(guess.message());
        System.out.println("The word: " + guess.word());
    }

    public void setScanner(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public void setScanner() {
        this.scanner = new Scanner(System.in);
    }
}
