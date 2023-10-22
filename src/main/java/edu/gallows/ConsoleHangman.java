package edu.gallows;

import java.util.Scanner;

class ConsoleHangman {

    private static String guessMassage = "Guess a letter:";
    private static String stopMassage = "Exit";
    private final static int maxAttempt = 5;

    private Session session;

    ConsoleHangman(Session session) {
        this.session = session;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println(guessMassage);
            var input = scanner.nextLine();

            if (input.equals(stopMassage)) {
                break;
            }

            if (input.length() != 1) {
                System.out.println("Invalid value");
                continue;
            }

            char[] charArray = input.toCharArray();

            GuessResult guessResult = tryGuess(this.session, input);
            printState(guessResult);
            // Конец игры при победе или поражении

            if (guessResult.message() == Session.loseMassage || guessResult.message() == Session.winMassage) {
                break;
            }
        }
    }

    private GuessResult tryGuess(Session session, String input) {
        return session.guess(input.charAt(0));
    }

    private void printState(GuessResult guess) {
        System.out.println(guess.message());
        System.out.println("The word: " + guess.word());
    }
}
