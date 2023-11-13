package edu.hw5;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    void checkPassword(){
        assertThat(Task4.checkPassword("Passwo~rd")).isEqualTo(true);
    }

    @Test
    void checkPasswordFalse(){
        assertThat(Task4.checkPassword("ha@hdbsdkao~")).isEqualTo(false);
    }
}
