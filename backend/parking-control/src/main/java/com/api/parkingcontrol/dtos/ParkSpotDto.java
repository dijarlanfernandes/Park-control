package com.api.parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkSpotDto {
    
    @NotBlank
    private String parkSpotNumber;
    @NotBlank
    @Size(max = 7)
    private String licensePlateCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String colorCar;
    @NotBlank
    private String reponsibleName;
    @NotBlank
    private String apartment;
    @NotBlank
    private String block;

    public String getParkSpotNumber() {
        return this.parkSpotNumber;
    }

    public void setParkSpotNumber(String parkSpotNumber) {
        this.parkSpotNumber = parkSpotNumber;
    }

    public String getLicensePlateCar() {
        return this.licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCar() {
        return this.brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return this.modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return this.colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public String getReponsibleName() {
        return this.reponsibleName;
    }

    public void setReponsibleName(String reponsibleName) {
        this.reponsibleName = reponsibleName;
    }

    public String getApartment() {
        return this.apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return this.block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

}