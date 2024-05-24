package com.example.Api_Crud_Vehicle.database;

import com.example.Api_Crud_Vehicle.models.Brand;
import com.example.Api_Crud_Vehicle.models.Vehicle;
import com.example.Api_Crud_Vehicle.repositories.BrandRepository;
import com.example.Api_Crud_Vehicle.repositories.VehicleRepository;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Database {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private BrandRepository brandRepository;

//    @Bean
//    CommandLineRunner initDatabase(VehicleRepository repository) {
//        return args -> {
//            Brand brandA = new Brand("C", "Car", "Car");
//            Brand brandB = new Brand("T", "Truck", "Truck");
//            Brand brandC = new Brand("B", "Bus", "Bus");
//            Vehicle vehicleA = new Vehicle("Porsche 911", 2018, 400000000.0,"Cuong Dollar", "C", "04/05/2019", brandA);
//            Vehicle vehicleB = new Vehicle("Porsche 911", 2018, 400000000.0,"Cuong Dollar", "C", "04/05/2019",brandA);
//            logger.info("Inserting vehicle A{}", repository.save(vehicleA));
//            logger.info("Inserting vehicle A{}", repository.save(vehicleB));
//        };
//    }

    @PostConstruct
    void init(){
        List<Vehicle> vehicles = new ArrayList<>();
        List<Brand> brands = new ArrayList<>();

        Brand brandA = new Brand("C", "Car", "Car");
        Brand brandB = new Brand("T", "Truck", "Truck");
        Brand brandC = new Brand("B", "Bus", "Bus");
        brands.add(brandA);
        brands.add(brandB);
        brands.add(brandC);
        brandRepository.saveAll(brands);

        Vehicle vehicleA = new Vehicle("Porsche 911", 2018, 400000000.0,"Cuong Dollar", "C",brandA);
        Vehicle vehicleB = new Vehicle("Porsche 911", 2018, 400000000.0,"Cuong Dollar", "C",brandA);
        vehicles.add(vehicleA);
        vehicles.add(vehicleB);
        vehicleRepository.saveAll(vehicles);

    }
}
