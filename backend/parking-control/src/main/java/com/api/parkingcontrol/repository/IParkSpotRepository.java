package com.api.parkingcontrol.repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parkingcontrol.models.ParkingSpotModel;

@Repository
 public interface IParkSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{
    
    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsByParkSpotNumber(String parkSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);
}