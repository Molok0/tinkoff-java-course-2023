package edu.gallows.DictionaryModel;

import org.jetbrains.annotations.NotNull;
import java.util.Random;

public class GallowsDictionary implements Dictionary{
    @Override
    public @NotNull String randomWord(String[] words) {
        Random random = new Random();
        int randomInt = random.nextInt(words.length);
        return words[randomInt];
    }
}
