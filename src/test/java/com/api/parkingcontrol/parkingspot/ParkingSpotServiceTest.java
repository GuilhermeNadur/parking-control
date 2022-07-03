package com.api.parkingcontrol.parkingspot;

import com.api.parkingcontrol.repository.ParkingSpotRepository;
import com.api.parkingcontrol.service.ParkingSpotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ParkingSpotServiceTest {

    @InjectMocks
    private ParkingSpotService parkingSpotService;

    @Mock
    private ParkingSpotRepository parkingSpotRepository;

    @Test
    void findAllWithPageable() {
        Pageable pageable = PageRequest.of(0, 10);
        parkingSpotService.findAll(pageable);
        verify(parkingSpotRepository).findAll(pageable);
    }
}
