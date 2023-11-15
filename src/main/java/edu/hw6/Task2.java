package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Task2 {
    private Task2() {
    }

    public static void cloneFile(Path path) {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            } else {
                var fileName = path.getFileName().toString().split("\\.");
                Path newFilePath = Path.of(path.getParent() + "\\" + fileName[0] + " — копия." + fileName[1]);
                if (!Files.exists(newFilePath)) {
                    Files.copy(path, newFilePath);
                } else {
                    int count = 2;
                    while (true) {
                        newFilePath =
                            Path.of(
                                path.getParent() + "\\" + fileName[0] + String.format(" — копия (%d)", count)
                                    + fileName[1]);
                        count += 1;
                        if (!Files.exists(newFilePath)) {
                            Files.copy(path, newFilePath);
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {

        }
    }
}
