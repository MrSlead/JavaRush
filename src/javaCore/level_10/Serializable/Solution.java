package javaCore.level_10.Serializable;

import java.io.IOException;                                                  
import java.io.ObjectInputStream;                                                  
import java.io.ObjectOutputStream;
import java.io.Serializable;                                                  
                                                                                                  
public class Solution implements Serializable, Runnable{                                                  
	private static final long serialVersionUID = 1L;
	private transient Thread runner;                                                  
    private int speed;                                                  
                                                  
    public Solution(int speed) {                                                  
        this.speed = speed;                                                  
        runner = new Thread(this);                                                  
        runner.start();                                                  
    }                                                  
                                                  
    public void run() {                                                  
        // do something here, doesn't matter what                                                  
    }                                                  
                                                  
    /**                                                  
     * Redefining serialization.                                                  
     * To do this, you must declare methods:                                                  
     * private void writeObject(ObjectOutputStream out) throws IOException                                                  
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException                                                  
     * Now the serialization/deserialization will go according to our script :)                                                  
     */                                                
    private void writeObject(ObjectOutputStream out) throws IOException {                                                  
        out.defaultWriteObject();                                                  
    }                                                  
                                                  
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {                                                  
        in.defaultReadObject();  
        runner = new Thread(this);
        runner.start();
    }                                                  
                                                  
    public static void main(String[] args) {                                                  
                                                  
    } 
    
    public int getSpeed() {
    	return speed;
    }
}