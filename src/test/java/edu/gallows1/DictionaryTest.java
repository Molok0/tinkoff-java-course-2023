package edu.gallows1;

import edu.gallows1.DictionaryModel.GallowsDictionary;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DictionaryTest {
    @Test
    void randomWord(){
        String[] words = new String[]{"test", "string"};
        assertThat(new GallowsDictionary().randomWord(words)).isNotEqualTo("");
    }
}
