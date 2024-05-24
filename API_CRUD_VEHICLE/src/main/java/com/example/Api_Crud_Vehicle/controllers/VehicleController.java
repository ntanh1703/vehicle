package com.example.Api_Crud_Vehicle.controllers;

import com.example.Api_Crud_Vehicle.models.Vehicle;
import com.example.Api_Crud_Vehicle.services.VehicleService;
import com.example.Api_Crud_Vehicle.services.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/v3/home")
public class VehicleController {
    @Autowired
    private final VehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping("/")
//    ResponseEntity<List<Map<String, Object>>> getAllVehicles() {
//        List<Object[]> vehicleBrandInfoList = vehicleService.getAllVehicles();
//        List<Map<String, Object>> response = vehicleBrandInfoList.stream()
//                .map(this::mapToResponseMap)
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(response, HttpStatus.OK);
    public List<Vehicle> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }
//    private Map<String, Object> mapToResponseMap(Object[] vehicleBrandInfo) {
//        Map<String, Object> responseMap = new HashMap<>();
//        responseMap.put("vehicle", vehicleBrandInfo[0]);
//        responseMap.put("brand", vehicleBrandInfo[1]);
//        return responseMap;
//    }

    @GetMapping("/{id}")
    ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id){
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @PutMapping("/update/{id}")
    Vehicle updateVehicle(@RequestBody Vehicle vehicle, @PathVariable Long id){
        return vehicleService.updateVehicle(vehicle, id);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Delete successfully");
    }

    @GetMapping("/search")
    public List<Vehicle> searchVehicle(@RequestParam(required = false) String brandId,
                                       @RequestParam(required = false) Integer year,
                                       @RequestParam(required = false) Double price,
                                       @RequestParam(required = false) String owner){
        if (brandId == null && year == null && price == null && owner == null) {
            return vehicleService.getAllVehicles();
        }

        Vehicle search = new Vehicle();
        search.setBrandId(brandId);
        search.setYear(year != null ? year : 0);
        search.setPrice(price != null ? price : 0);
        search.setOwner(owner);

        return vehicleService.searchVehicle(search);
    }

    @GetMapping("/search/price")
    public ResponseEntity<List<Vehicle>> searchVehicles(){
        List<Vehicle> vehicles = vehicleService.searchVehicle1();
        return ResponseEntity.ok(vehicles);

    }
}
