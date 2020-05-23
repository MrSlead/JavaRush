package javaCollections.level_2.RMI2;

import java.rmi.Remote;                                                  
import java.rmi.RemoteException;                                                  
                                                  
public interface Animal extends Remote {                                                  
    void speak() throws RemoteException;                                                  
                                                  
    void printName() throws RemoteException;                                                  
}