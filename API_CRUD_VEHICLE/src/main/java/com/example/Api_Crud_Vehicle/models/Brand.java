package com.example.Api_Crud_Vehicle.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Data
@Entity
@Table(name="brand")
public class Brand {
    @Id
    private String brandId;
    private String brandName;
    private String type;

//    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
//    private Set<Vehicle> vehicle;

    public Brand(){}

    public Brand(String brandId, String brandName, String type) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.type = type;
    }
}
