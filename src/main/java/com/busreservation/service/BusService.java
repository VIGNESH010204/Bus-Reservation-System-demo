package com.busreservation.service;

import com.busreservation.model.Bus;
import com.busreservation.repository.BusRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BusService {
    private final BusRepository busRepository;

    public BusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }
}
