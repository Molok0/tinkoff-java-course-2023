package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Task6 {

    private static final int START_PORT = 0;
    private static final int END_PORT = 70;
    private static final String PROTOCOL_PRINT = "Protocol";
    private static final String SERVICE_PRINT = "Service";
    private static final String PORT_PRINT = "Port";
    private static final String TCP_PRINT = "TCP";
    private static final String UDP_PRINT = "UDP";
    private static final String PATH_TO_FILES_WITH_PORTS =
        "C:\\Users\\dopro\\IdeaProjects\\java-course-2023\\src\\main\\java\\edu\\hw6\\Task6\\PortsList.txt";
    private static final String FORMAT_PATTERN = "%-15s%-15s%-15s%n";
    private static final Map<Integer, List<String>> KNOWN_PORTS = getKnownPorts();

    private static Map<Integer, List<String>> getKnownPorts() {
        Map<Integer, List<String>> knownPorts = new HashMap<>();
        Path path =
            Path.of(PATH_TO_FILES_WITH_PORTS);

        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                String[] allArguments = line.strip().split(":");
                int portNumber = Integer.parseInt(allArguments[0]);
                String portName = allArguments[1];
                String serviceName = allArguments[2];
                knownPorts.put(portNumber, List.of(portName, serviceName));
            }
            return knownPorts;
        } catch (IOException e) {

        }
        return null;
    }

    private Task6() {
    }


    public static void scanPorts() {
        System.out.format(FORMAT_PATTERN, PROTOCOL_PRINT, PORT_PRINT, SERVICE_PRINT);
        for (int portNumber = START_PORT; portNumber <= END_PORT + 1; portNumber++) {
            try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
                System.out.format(FORMAT_PATTERN, TCP_PRINT, portNumber, "");
            } catch (IOException e) {
                try (DatagramSocket datagramSocket = new DatagramSocket(portNumber)) {
                    System.out.format(FORMAT_PATTERN, UDP_PRINT, portNumber, "");
                } catch (SocketException ex) {
                    if (KNOWN_PORTS.containsKey(portNumber)) {
                        System.out.format(FORMAT_PATTERN, KNOWN_PORTS.get(portNumber).get(0),
                            portNumber, KNOWN_PORTS.get(portNumber).get(1)
                        );
                    } else {
                        System.out.format(FORMAT_PATTERN, "", portNumber, "");
                    }

                }
            }
        }
    }
}
