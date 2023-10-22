package edu.gallows.DictionaryModel;

import org.jetbrains.annotations.NotNull;

interface Dictionary {
    @NotNull String randomWord(String[] words);
}
