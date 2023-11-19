package edu.hw6.Task3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static edu.hw6.Task3.AbstractFilter.globMatches;
import static edu.hw6.Task3.AbstractFilter.largerThan;
import static edu.hw6.Task3.AbstractFilter.magicNumber;
import static edu.hw6.Task3.AbstractFilter.regexContains;
import static org.assertj.core.api.Assertions.assertThat;

class AbstractFilterTest {

    public static final AbstractFilter regularFile = Files::isRegularFile;
    public static final AbstractFilter readable = Files::isReadable;

    @Test
    void testAbstractFilter() {
        Path dir = Paths.get("C:\\Users\\dopro\\IdeaProjects\\java-course-2023\\src\\test\\java\\edu\\hw6\\Task3");
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(largerThan(0))
            .and(magicNumber((byte) 0x89, (byte) 'P', (byte) 'N', (byte) 'G'))
            .and(globMatches("*.png"))
            .and(regexContains("[-]"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {

            List<String> files = new ArrayList<>();
            entries.forEach(path -> files.add(path.getFileName().toString()));
            assertThat(files).containsOnly("go-lub.png");
        } catch (IOException e) {

        }
    }

    @Test
    void testAbstractFilter2() {
        Path dir = Paths.get("C:\\Users\\dopro\\IdeaProjects\\java-course-2023\\src\\test\\java\\edu\\hw6\\Task3");
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(globMatches("*.txt"))
            .and(regexContains("^t"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {

            List<String> files = new ArrayList<>();
            entries.forEach(path -> files.add(path.getFileName().toString()));
            assertThat(files).containsOnly("text.txt");
        } catch (IOException e) {

        }
    }
}
