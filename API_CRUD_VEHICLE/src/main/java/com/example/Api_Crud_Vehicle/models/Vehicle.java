package com.example.Api_Crud_Vehicle.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Data
@Entity
@Table(name="vehicle")
public class Vehicle {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @SequenceGenerator(
//            name = "product_sequence",
//            sequenceName = "vehicle_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "vehicle_sequence"
//    )
    private Long id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private Integer year;

    @Setter
    private Double price;

    @Setter
    @Getter
    private String owner;

    @Setter
    @Getter
    @Column(name = "brandId", insertable = false, updatable = false)
    private String brandId;

    @Setter
    @Getter
    private Instant instant;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    public Vehicle() {}

    public Vehicle(String name, Integer year, Double price, String owner, String brandId, Brand brand) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.owner = owner;
        this.brandId = brandId;
        this.brand = brand;
    }

    @PrePersist
    public void prePersist() {
        this.instant = Instant.now();
    }


    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", owner='" + owner + '\'' +
                ", brand_id='" + brandId + '\'' +
                ", instant='" + instant + '\'' +
                '}';
    }
}
