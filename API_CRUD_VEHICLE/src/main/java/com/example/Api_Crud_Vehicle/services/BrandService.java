package com.example.Api_Crud_Vehicle.services;


import com.example.Api_Crud_Vehicle.models.Brand;
import com.example.Api_Crud_Vehicle.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface BrandService {
    Brand getBrandByBrandId(String brandId);
}
