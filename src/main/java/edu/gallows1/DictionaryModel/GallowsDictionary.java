package edu.gallows1.DictionaryModel;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class GallowsDictionary implements Dictionary {
    @Override
    public @NotNull String randomWord(String[] words) {
        Random random = new Random();
        int randomInt = random.nextInt(words.length);
        return words[randomInt];
    }
}
