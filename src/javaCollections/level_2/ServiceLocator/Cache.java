package javaCollections.level_2.ServiceLocator;
                                               

import java.util.ArrayList;                                                  
import java.util.List;

import javaCollections.level_2.ServiceLocator.service.Service;                                                  
                                                  
public class Cache {                                                  
    private List<Service> services;                                                  
                                                  
    public Cache() {                                                  
        services = new ArrayList<>();                                                  
    }                                                  
                                                  
    public Service getService(String serviceName) {                                                  
        for (Service service : services) {                                                  
            if (service.getName().equalsIgnoreCase(serviceName)) {                                                  
                System.out.println("Return cached  " + serviceName + " object");                                                  
                return service;                                                  
            }                                                  
        }                                                  
        return null;                                                  
    }                                                  
                                                  
    public void addService(Service newService) {                                                  
        boolean exists = false;                                                  
        for (Service service : services) {                                                  
            if (service.getName().equalsIgnoreCase(newService.getName())) {                                                  
                exists = true;                                                  
            }                                                  
        }                                                  
        if (!exists) {                                                  
            services.add(newService);                                                  
        }                                                  
    }                                                  
}