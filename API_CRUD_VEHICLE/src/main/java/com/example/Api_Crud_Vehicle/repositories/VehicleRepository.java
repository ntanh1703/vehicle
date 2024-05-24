package com.example.Api_Crud_Vehicle.repositories;

import com.example.Api_Crud_Vehicle.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE (:brandId is not null and v.brandId = :brandId) " +
            "OR (:year is not null and v.year = :year) " +
            "OR (:price is not null and v.price = :price) " +
            "OR (:owner is not null and v.owner = :owner)")
    List<Vehicle> searchByCriteria(String brandId, Integer year, Double price, String owner);

    @Query("SELECT v FROM Vehicle v WHERE (v.price > 10000000.0 AND v.name LIKE 'S%') " +
            "OR (v.price <= 10000000.0 AND v.brandId = 'B')")
    List<Vehicle> searchVehicle1();
}
