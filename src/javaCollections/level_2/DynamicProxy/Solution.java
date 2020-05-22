package javaCollections.level_2.DynamicProxy;

import java.lang.reflect.Proxy;

/*                                                   
Создание прокси-объекта                                                  
*/                                                  
public class Solution {                                                  
    public static void main(String[] args) {                                                  
        SomeInterfaceWithMethods obj = getProxy();                                                  
        obj.stringMethodWithoutArgs();                                                  
        obj.voidMethodWithIntArg(1);                                                  
                                                  
        /* expected output                                                  
        stringMethodWithoutArgs in                                                  
        inside stringMethodWithoutArgs                                                  
        stringMethodWithoutArgs out                                                  
        voidMethodWithIntArg in                                                  
        inside voidMethodWithIntArg                                                  
        inside voidMethodWithoutArgs                                                  
        voidMethodWithIntArg out                                                  
        */                                                  
    }                                                  
                                                  
    public static SomeInterfaceWithMethods getProxy() {                                                  
        SomeInterfaceWithMethods instance = new SomeInterfaceWithMethodsImpl();
        
        ClassLoader loader = instance.getClass().getClassLoader();
        Class<?>[] interfaces = instance.getClass().getInterfaces();
        CustomInvocationHandler h = new CustomInvocationHandler(instance);
        
        SomeInterfaceWithMethods proxy = (SomeInterfaceWithMethods) Proxy.newProxyInstance(loader, interfaces, h);
        
        return proxy;
    }                                                  
}