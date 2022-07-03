package com.api.parkingcontrol.parkingspot;

import com.api.parkingcontrol.model.ParkingSpot;
import com.api.parkingcontrol.repository.ParkingSpotRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ParkingSpotRepositoryTest {

    @Autowired
    private ParkingSpotRepository parkingSpotRepository;

    @AfterEach
    void tearDown() {
        parkingSpotRepository.deleteAll();
    }

    @Test
    void existsByLicensePlateCar() {
        ParkingSpot actual = new ParkingSpot("200A", "AOT7600", "BMW", "X1", "White", "Ronaldo Pereira", "205", "A");
        actual.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        parkingSpotRepository.save(actual);
        boolean expected = parkingSpotRepository.existsByLicensePlateCar("AOT7600");
        assertTrue(expected);
    }

    @Test
    void notExistsByLicensePlateCar() {
        boolean expected = parkingSpotRepository.existsByLicensePlateCar("AOT7600");
        assertFalse(expected);
    }
}