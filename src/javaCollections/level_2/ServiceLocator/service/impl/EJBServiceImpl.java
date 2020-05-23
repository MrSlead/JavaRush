package javaCollections.level_2.ServiceLocator.service.impl;

import javaCollections.level_2.ServiceLocator.service.Service;

public class EJBServiceImpl implements Service {                                                  
    
    @Override                                                  
    public void execute() {                                                  
        System.out.println("Executing the EJBService");                                                  
    }                                                  
                                                  
    @Override                                                  
    public String getName() {                                                  
        return "EJBService";                                                  
    }                                                  
                                                  
}