package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {

    static AbstractFilter readable(Path path) {
        return Files.isReadable(path) ? path::equals : null;
    }

    static AbstractFilter writable(Path path) {
        return Files.isWritable(path) ? path::equals : null;
    }

    static AbstractFilter regularFile(Path path) {
        return Files.isRegularFile(path) ? path::equals : null;
    }

    static AbstractFilter largerThan(int size) {
        return path -> Files.size(path) >= size;
    }

    static AbstractFilter magicNumber(byte... elements) {
        return path -> {
            try {
                byte[] bytes = Files.readAllBytes(path);
                if (bytes.length >= elements.length) {
                    for (int i = 0; i < elements.length; i++) {
                        if (bytes[i] != elements[i]) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
            return false;
        };
    }

    static AbstractFilter globMatches(String glob) {
        return path -> FileSystems.getDefault().getPathMatcher("glob:" + glob).matches(path.getFileName());
    }

    static AbstractFilter regexContains(String regex) {
        return path ->
            path.getFileName().toString().matches(".*" + regex + ".*");
    }

    default AbstractFilter and(AbstractFilter other) {
        return path -> this.accept(path) && other.accept(path);
    }
}
