package edu.gallows1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    @NotNull String word();

    int attempt();

    @NotNull String message();

    record Defeat(String word, int attempt, String message) implements GuessResult {
    }

    record Win(String word, int attempt, String message) implements GuessResult {
    }

    record SuccessfulGuess(String word, int attempt, String message) implements GuessResult {
    }

    record FailedGuess(String word, int attempt, String message) implements GuessResult {
    }

}
