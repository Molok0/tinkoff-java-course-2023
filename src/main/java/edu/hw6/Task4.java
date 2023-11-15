package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public final class Task4 {
    private Task4() {
    }

    public static void outputStreamComposition(Path path) {
        try (OutputStream os = Files.newOutputStream(path)) {
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(os, new CRC32());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            printWriter.write("Programming is learned by writing programs. ― Brian Kernighan");
            printWriter.close();
        } catch (IOException e) {

        }
    }
}
