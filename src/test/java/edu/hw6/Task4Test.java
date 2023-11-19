package edu.hw6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task4Test {
    private static final File FILE = new File("test.txt");

    @BeforeAll
    static void createFile() {
        try {
            FILE.createNewFile();
        } catch (IOException e) {

        }
    }

    @Test
    void outputStreamCompositionTest() {
        Task4.outputStreamComposition(FILE.getAbsoluteFile().toPath());
        try {
            assertThat(Files.readString(FILE.toPath().toAbsolutePath())).isEqualTo(
                "Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException e) {

        }
    }

    @Test
    void outputStreamCompositionTestFalse() {
        Task4.outputStreamComposition(FILE.getAbsoluteFile().toPath());
        try {
            assertThat(Files.readString(FILE.toPath().toAbsolutePath())).isNotEqualTo(
                "Programming is learned by writing programs. ― Brian Kernigha");
        } catch (IOException e) {

        }
    }
}
