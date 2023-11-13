package edu.hw5;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    void isRussianLicensePlate1() {
        assertThat(Task5.isRussianLicensePlate("А123ВЕ777")).isEqualTo(true);
    }

    @Test
    void isRussianLicensePlate2() {
        assertThat(Task5.isRussianLicensePlate("О777ОО177")).isEqualTo(true);
    }

    @Test
    void isRussianLicensePlate3() {
        assertThat(Task5.isRussianLicensePlate("123АВЕ777")).isEqualTo(false);
    }

    @Test
    void isRussianLicensePlate4() {
        assertThat(Task5.isRussianLicensePlate("А123ВГ77")).isEqualTo(false);
    }
    @Test
    void isRussianLicensePlate5() {
        assertThat(Task5.isRussianLicensePlate("А123ВЕ7777")).isEqualTo(false);
    }
}
