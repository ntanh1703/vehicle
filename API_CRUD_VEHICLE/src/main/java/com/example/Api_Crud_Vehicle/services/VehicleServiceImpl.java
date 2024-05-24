package com.example.Api_Crud_Vehicle.services;

import com.example.Api_Crud_Vehicle.models.Brand;
import com.example.Api_Crud_Vehicle.models.Vehicle;
import com.example.Api_Crud_Vehicle.repositories.BrandRepository;
import com.example.Api_Crud_Vehicle.repositories.VehicleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    private final VehicleRepository vehicleRepository;
    private final BrandRepository brandRepository;




    public VehicleServiceImpl(VehicleRepository vehicleRepository, BrandRepository brandRepository){
        this.vehicleRepository = vehicleRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicle = vehicleRepository.findAll();
//        return vehicle.stream().map(this::mapVehicleWithBrandInfo).collect(Collectors.toList());
        return vehicle;
    }


//    @Override
//    public Object[] mapVehicleWithBrandInfo(Vehicle vehicle){
//        Brand brand = brandRepository.findById(vehicle.getBrand_id()).orElse(null);
//        return new Object[]{vehicle, brand};
//    }

    @Override
    public Optional<Vehicle> getVehicleById(Long id){
        return vehicleRepository.findById(id);
    }

    public Brand getBrandByBrandId(String brandId) {
        return brandRepository.findByBrandId(brandId);
    }
    
    @Override
    public Vehicle addVehicle(Vehicle vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleDto.getName());
        vehicle.setYear(vehicleDto.getYear());
        vehicle.setBrandId(vehicleDto.getBrandId());
        vehicle.setPrice(vehicleDto.getPrice());
        vehicle.setOwner(vehicleDto.getOwner());
        vehicle.setInstant(vehicleDto.getInstant());

        Brand brand = brandRepository.getBrandByBrandId(vehicleDto.getBrandId());

        vehicle.setBrand(brand);


        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle updateVehicle, Long id) {
        Optional<Vehicle> found = vehicleRepository.findById(id);
        Vehicle vehicle;
        if (found.isPresent()) {
            vehicle = found.get();
            vehicle.setName(updateVehicle.getName());
            vehicle.setPrice(updateVehicle.getPrice());
            vehicle.setOwner(updateVehicle.getOwner());
            vehicle.setYear(updateVehicle.getYear());
            vehicle.setBrandId(updateVehicle.getBrandId());
            vehicle.setInstant(updateVehicle.getInstant());

            Brand brand = brandRepository.getBrandByBrandId(updateVehicle.getBrandId());

            vehicle.setBrand(brand);

            return vehicleRepository.save(vehicle);
        } else {
            throw new EntityNotFoundException("Cannot find vehicle");
        }

    }

    @Override
    public void deleteVehicle(Long id){
        Vehicle found = vehicleRepository.findById(id).orElseThrow(()-> new RuntimeException("Cannot find vehicle"));
        vehicleRepository.delete(found);
    }

    @Override
    public List<Vehicle> searchVehicle(Vehicle search) {
        return vehicleRepository.searchByCriteria(search.getBrandId(), search.getYear(), search.getPrice(), search.getOwner());
    }

    @Override
    public List<Vehicle> searchVehicle1(){
        return vehicleRepository.searchVehicle1();
    }
}
