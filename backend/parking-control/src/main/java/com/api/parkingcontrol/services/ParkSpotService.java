package com.api.parkingcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repository.IParkSpotRepository;

@Service
public class ParkSpotService {
    
    final IParkSpotRepository iParkSpotRepository;

    public ParkSpotService(IParkSpotRepository iParkSpotRepository) {
        this.iParkSpotRepository = iParkSpotRepository;
    }
    @TransactionScoped
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return iParkSpotRepository.save(parkingSpotModel);
    }
    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return iParkSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }
    public boolean existsByParkSpotNumber(String parkSpotNumber) {
        return iParkSpotRepository.existsByParkSpotNumber(parkSpotNumber);
    }
    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return iParkSpotRepository.existsByApartmentAndBlock(apartment, block);
    }
    public List<ParkingSpotModel> findAll() {
        return iParkSpotRepository.findAll();
    }
    public Optional<ParkingSpotModel> findById(UUID id) {
        return iParkSpotRepository.findById(id);
    }
    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
        iParkSpotRepository.delete(parkingSpotModel);
    }
      
}