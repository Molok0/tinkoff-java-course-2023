package edu.hw8.Task1;

import java.io.IOException;

public class StartApp {

    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = new Server();
        Client client = new Client();
        Thread s = new Thread(() -> {
            try {
                server.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        s.start();
        Thread.sleep(1000);
        client.start();
        s.join();
    }
}
