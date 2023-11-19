package edu.hw6;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String>, Serializable {

    public Map<String, String> getData() {
        return data;
    }

    private static final int BUFFER_SIZE = 1024;
    private Map<String, String> data = new HashMap<>();
    private static String filePath;

    public DiskMap(String filePath) {
        this.filePath = filePath;
    }

    public void save() {
        try {
            FileChannel inChannel = FileChannel.open(
                Path.of(filePath),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING
            );
            ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

            for (var entry : data.entrySet()) {
                var tmp = entry.getKey() + ":" + entry.getValue() + System.lineSeparator();
                buffer.put(tmp.getBytes());
            }
            buffer.flip();

            while (buffer.hasRemaining()) {
                inChannel.write(buffer);
            }
            buffer.clear();
            inChannel.close();
        } catch (IOException e) {

        }
    }

    public String readFile() {
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

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.data.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.data.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return this.data.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        return data.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return data.remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        data.putAll(m);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return this.data.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return this.data.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return this.data.entrySet();
    }
}
