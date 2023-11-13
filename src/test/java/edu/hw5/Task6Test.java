package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    void checkPassword(){
        assertThat(Task6.stringIsSubsequenceOfString("abc","achfdbaabgabcaabg")).isEqualTo(true);
    }
    @Test
    void checkPasswordFalse(){
        assertThat(Task6.stringIsSubsequenceOfString("!abc","achfdbaabgabcaabg")).isEqualTo(false);
    }
}
