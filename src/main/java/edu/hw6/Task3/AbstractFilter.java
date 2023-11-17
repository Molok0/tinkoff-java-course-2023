package edu.hw6.Task3;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {

    static AbstractFilter readable(Path path) {
        return Files.isReadable(path) ? path::equals : null;
    }

    static AbstractFilter writable(Path path) {
        return Files.isWritable(path) ? path::equals : null;
    }

    static AbstractFilter largerThan(int size) {
        return path -> Files.size(path) >= size;
    }

    static AbstractFilter magicNumber(byte... elements) {
        return path -> {
            int sizeFile = elements.length;
            try (FileInputStream inputStream = new FileInputStream(path.toFile())) {
                var a = inputStream.readNBytes(sizeFile);
                if (elements.equals(a)) {
                    return true;
                }
                return false;
            } catch (IOException e) {
                return false;
            }
        };
    }

    static AbstractFilter globMatches(String glob) {
        return path -> path.toString().matches(glob);
    }

    static AbstractFilter regexContains(String regex) {
        return path -> {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(path.toString());
            return matcher.find();
        };
    }

    default boolean accept(AbstractFilter entry) throws IOException {
        return false;
    }
}
