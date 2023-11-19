package edu.hw6.Task6;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Task6Test {
    private static final String FORMAT_PATTERN = "%-15s%-15s%-15s%n";

    @Test
    void scanPortsTest() {
        Task6.scanPorts();
        Task6.getTable();
        assertThat(Task6.getTable()).isEqualTo(List.of(
            String.format(FORMAT_PATTERN, "Protocol", "Port", "Service"),
            String.format(FORMAT_PATTERN, "", "0", "Port Open"),
            String.format(FORMAT_PATTERN, "TCP", "1", "TCPMUX"),
            String.format(FORMAT_PATTERN, "UDP", "2", "COMPRESSNET"),
            String.format(FORMAT_PATTERN, "UDP", "3", "COMPRESSNET"),
            String.format(FORMAT_PATTERN, "", "4", "Port Open"),
            String.format(FORMAT_PATTERN, "TCP", "5", "RJE")
        ));
    }
}
