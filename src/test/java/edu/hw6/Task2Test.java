package edu.hw6;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task2Test {

    private static final String FILE = "Tinkoff Bank Biggest Secret.txt";
    private static final String FILE_COPY = "Tinkoff Bank Biggest Secret — копия.txt";
    private static final String FILE_COPY2 = "Tinkoff Bank Biggest Secret — копия (2).txt";

    @Test
    void cloneFile(@TempDir Path path) {
        Path file = Path.of(String.valueOf(path.resolve(FILE)));
        Task2.cloneFile(file);
        assertThat(Files.exists(file)).isEqualTo(true);
    }

    @Test
    void cloneFile1(@TempDir Path path) {
        Path file = Path.of(String.valueOf(path.resolve(FILE)));
        Task2.cloneFile(file);
        Task2.cloneFile(file);
        Path fileCopy = Path.of(String.valueOf(path.resolve(FILE_COPY)));
        assertThat(Files.exists(fileCopy)).isEqualTo(true);
    }

    @Test
    void cloneFile2(@TempDir Path path) {
        Path file = Path.of(String.valueOf(path.resolve(FILE)));
        Task2.cloneFile(file);
        Task2.cloneFile(file);
        Task2.cloneFile(file);
        Path fileCopy = Path.of(String.valueOf(path.resolve(FILE_COPY2)));
        assertThat(Files.exists(fileCopy)).isEqualTo(true);
    }

}
