package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
    private final static Logger LOGGER = LogManager.getLogger();
    private static final int PORT = 1090;
    private static final String HOSTNAME = "localhost";
    private static ByteBuffer buffer;
    private static int bufferSize = 256;

    public Client() {
    }

    public void start() {
        try (SocketChannel client = SocketChannel.open()) {
            client.connect(new InetSocketAddress(HOSTNAME, PORT));
            buffer = ByteBuffer.allocate(bufferSize);
            LOGGER.info(sendMessage("глупый", client) + "1");
        } catch (IOException e) {

        }
    }

    private String sendMessage(String msg, SocketChannel client) {
        buffer = ByteBuffer.wrap(msg.getBytes());
        String response = null;
        try {
            client.write(buffer);
            buffer.clear();
            client.read(buffer);
            response = new String(buffer.array()).trim();
            buffer.clear();
            client.close();
        } catch (IOException e) {
            LOGGER.info(e);
        }
        return response;
    }
}
