package com.api.parkingcontrol.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.ParkSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkSpotService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {

    final ParkSpotService parkSpotService;

    public ParkingSpotController(ParkSpotService parkSpotService) {

        this.parkSpotService = parkSpotService;
    }


    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkSpotDto parkSpotDto){
        
	
	  if (parkSpotService.existsByLicensePlateCar(parkSpotDto
					.getLicensePlateCar())){
            			return ResponseEntity.status
					(HttpStatus.CONFLICT)
					.body("Conflict:License Plate Car is already is use");
        }

        if(parkSpotService.existsByParkSpotNumber(parkSpotDto
		.getParkSpotNumber())){
          return ResponseEntity
		.status(HttpStatus.CONFLICT)
		.body("Conflited: ParKing Spot Number is aready is Use");

        }

        if(parkSpotService.existsByApartmentAndBlock(
			parkSpotDto.getApartment(), 
			parkSpotDto.getBlock())){
            	return ResponseEntity.status
			(HttpStatus.CONFLICT)
			.body("Confilct:Apartment and Block is in use");
        }

        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkSpotDto, parkingSpotModel);

        parkingSpotModel
		.setRegistrationDate(LocalDateTime
		.now(ZoneId.of("UTC")));

        return ResponseEntity.status(
		HttpStatus.CREATED)
		.body(parkSpotService.save(parkingSpotModel));

    }

    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getallParkSpots(){

        return ResponseEntity.status(HttpStatus.OK)
				.body(parkSpotService.findAll());

    }


    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getOneParkSpot(@PathVariable(value = "id")UUID id) {

        Optional<ParkingSpotModel> parkingSpotModelOptional = parkSpotService.findById(id);
        
			if(!parkingSpotModelOptional.isPresent()){
                	return ResponseEntity.status(	
				HttpStatus.CONFLICT)
				.body("ParkSpot not found");
        }
        return ResponseEntity.status(HttpStatus.OK)	
	   		.body(parkingSpotModelOptional.get());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkSpot(@PathVariable(value = "id") UUID id){
        var parkingSpotModel = parkSpotService.findById(id);

        if (!parkingSpotModel.isPresent()) {
            return ResponseEntity
			.status(HttpStatus.NOT_FOUND)
			.body("Parkspot Not found");
        }

        parkSpotService.delete(parkingSpotModel.get());
        return ResponseEntity.status(HttpStatus.OK)
			.body("Parking spot deleted ");
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkSpot(@PathVariable(value = "id") UUID id,
                                                              @RequestBody ParkSpotDto parkSpotDto) {

        Optional<ParkingSpotModel> parkingSpotModelOptional = parkSpotService.findById(id);

        if (!parkingSpotModelOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body("Paking spot not found");
        }

        var parkingSpotModel = new ParkingSpotModel();

        BeanUtils.copyProperties(parkSpotDto, parkingSpotModel);

        parkingSpotModel.setId(parkingSpotModelOptional.get().getId());

        parkingSpotModel.setRegistrationDate(
				parkingSpotModelOptional.get().getRegistrationDate());
        
		return ResponseEntity.status(HttpStatus.OK)
				.body(parkSpotService.save(parkingSpotModel));
    }
    
}