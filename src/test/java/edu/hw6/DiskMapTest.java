package edu.hw6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class DiskMapTest {

    private static final File FILE = new File("test1.txt");

    @BeforeAll
    static void createFile()  {
        try {
            var file = FILE.createNewFile();
        }catch (IOException e){

        }
    }

    @AfterAll
    static void deleteFile(){
        FILE.delete();
    }

    @Test
    void diskMapPutTest(){
        DiskMap diskMap = new DiskMap(FILE.getPath());
        diskMap.put("1", "A");
        diskMap.put("2", "B");
        diskMap.put("3", "C");
        diskMap.save();
        assertThat(diskMap.readFile()).isEqualTo(read(FILE.getPath()));
    }

    @Test
    void diskMapRemoveTest(){
        DiskMap diskMap = new DiskMap(FILE.getPath());
        diskMap.put("1", "A");
        diskMap.put("2", "B");
        diskMap.put("3", "C");
        diskMap.save();
        diskMap.remove("1");
        diskMap.save();
        assertThat(diskMap.readFile()).isEqualTo(read(FILE.getPath()));
    }
    @Test
    void diskMapRemoveTestFalse(){
        DiskMap diskMap = new DiskMap(FILE.getPath());
        diskMap.put("1", "A");
        diskMap.put("2", "B");
        diskMap.put("3", "C");
        diskMap.save();
        diskMap.remove("1");
        assertThat(diskMap.readFile()).isNotEqualTo(diskMap.getData().toString());
    }

    private static String read(String filePath){
        try {
            FileChannel inChannel = FileChannel.open(Path.of(filePath));
            ByteBuffer buffer = ByteBuffer.allocate((int) inChannel.size());

            int bytesRead = inChannel.read(buffer);
            StringBuilder stringBuilder = new StringBuilder();
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    stringBuilder.append((char) buffer.get());
                }
                buffer.clear();
                bytesRead = inChannel.read(buffer);
            }
            inChannel.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            return "Error reading from file";
        }
    }

}
