package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int PORT = 1090;
    private static final String HOSTNAME = "localhost";

    private static final Map<String, String> WORDS = new HashMap<>();

    public Server() {
        WORDS.put("личности", "Не переходи на личности там, где их нет");
        WORDS.put(
            "оскорбления",
            "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами"
        );
        WORDS.put(
            "глупый",
            "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма."
        );
        WORDS.put("интеллект", "Чем ниже интеллект, тем громче оскорбления");
    }

    public void start() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(HOSTNAME, PORT));
        serverSocket.configureBlocking(false);
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectedKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    register(selector, serverSocket);
                }
                if (key.isReadable()) {
                    executorService.submit(() -> {
                        try {
                            answer(key);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }
                iterator.remove();
            }
        }
    }

    private void answer(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(256);
        int r = client.read(buffer);
        if (r == -1) {
            client.close();
        } else {
            buffer.flip();
            client.write(buffer);
            buffer.clear();
        }

    }

    private void register(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel socketChannel = serverSocket.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }
}
