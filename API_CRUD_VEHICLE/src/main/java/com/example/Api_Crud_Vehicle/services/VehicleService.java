package com.example.Api_Crud_Vehicle.services;

import com.example.Api_Crud_Vehicle.models.Vehicle;

import java.util.List;
import java.util.Optional;


public interface VehicleService {
    List<Vehicle> getAllVehicles();
//    Object[] mapVehicleWithBrandInfo(Vehicle vehicle);
    Optional<Vehicle> getVehicleById(Long id);
    Vehicle addVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle, Long id);
    void deleteVehicle(Long id);
    List<Vehicle> searchVehicle(Vehicle vehicle);
    List<Vehicle> searchVehicle1();
}
