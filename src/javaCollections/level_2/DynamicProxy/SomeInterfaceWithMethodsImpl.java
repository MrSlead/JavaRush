package javaCollections.level_2.DynamicProxy;

public class SomeInterfaceWithMethodsImpl implements SomeInterfaceWithMethods {                                                  
    public void voidMethodWithoutArgs() {                                                  
        System.out.println("inside voidMethodWithoutArgs");                                                  
    }                                                  
                                                  
    public String stringMethodWithoutArgs() {                                                  
        System.out.println("inside stringMethodWithoutArgs");                                                  
        return null;                                                  
    }                                                  
                                                  
    public void voidMethodWithIntArg(int i) {                                                  
        System.out.println("inside voidMethodWithIntArg");                                                  
        voidMethodWithoutArgs();                                                  
    }                                                  
}