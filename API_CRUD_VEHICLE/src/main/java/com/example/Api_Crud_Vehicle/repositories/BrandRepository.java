package com.example.Api_Crud_Vehicle.repositories;

import com.example.Api_Crud_Vehicle.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {
    Brand findByBrandId(String brandId);


    Brand getBrandByBrandId(String brandId);
}
