package com.busreservation.bus_reservation_system;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTest {

    @Test
    void contextLoads() {
        // ✅ This will check if the Spring Application Context loads correctly
    }

    @Test
    void sampleTest() {
        int expected = 10;
        int actual = 5 + 5;
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual);
    }
}
