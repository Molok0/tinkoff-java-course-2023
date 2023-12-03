package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    private static final int SLEEP_TIME = 500;
    private static final int PORT = 1090;
    private static final String HOSTNAME = "localhost";
    private static ByteBuffer buffer;

    public Client() {
    }

    public void start() {
        try (SocketChannel client = SocketChannel.open()) {
            client.connect(new InetSocketAddress(HOSTNAME, PORT));
            buffer = ByteBuffer.allocate(256);
            System.out.println(sendMessage("глупый", client) + "1");
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
            e.printStackTrace();
        }
        return response;
    }
}
