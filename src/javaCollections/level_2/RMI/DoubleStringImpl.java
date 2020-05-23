package javaCollections.level_2.RMI;

import java.rmi.RemoteException;                                                  

public class DoubleStringImpl implements DoubleString {                                                  
    public String doubleString(String str) throws RemoteException {                                                  
        return str + str;                                                  
    }                                                  
}