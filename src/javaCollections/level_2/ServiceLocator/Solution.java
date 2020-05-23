package javaCollections.level_2.ServiceLocator;

import javaCollections.level_2.ServiceLocator.service.Service;

/*                                                   
Service Locator                                                  
*/                                                  
                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
        Service service = ServiceLocator.getService("EJBService");                                                  
        service.execute();                                                  
        System.out.println();                                                  
        service = ServiceLocator.getService("JMSService");                                                  
        service.execute();                                                  
        System.out.println();                                                  
        service = ServiceLocator.getService("EJBService");                                                  
        service.execute();                                                  
        System.out.println();                                                  
        service = ServiceLocator.getService("JMSService");                                                  
        service.execute();                                                  
                                                  
    }                                                  
                                                  
}