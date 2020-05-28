package javaCollections.level_3.JSON4;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.MINIMAL_CLASS, property = "className")
public class ParkingLot {                                                  
    public String name;                                                  
    public String city;                                                  
    public List<Vehicle> vehicles;                                                  
                                                  
    public ParkingLot(String name, String city) {                                                  
        this.name = name;                                                  
        this.city = city;                                                  
    }                                                  
                                                  
    public void setVehicles(List<Vehicle> vehicles) {                                                  
        this.vehicles = vehicles;                                                  
    }                                                  
                                                  
    @Override                                                  
    public String toString() {                                                  
        return "ParkingLot{" +                                                  
                "name='" + name + '\'' +                                                  
                ", city='" + city + '\'' +                                                  
                ", vehicles=" + vehicles +                                                  
                '}';                                                  
    }                                                  
}