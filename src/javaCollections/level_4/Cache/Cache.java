package javaCollections.level_4.Cache;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

import javaCollections.level_4.Cache.Solution.SomeKey;                                                  

public class Cache<K, V> {                                                  
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here                                                  
                                                  
    public V getByKey(K key, Class<V> clazz) throws Exception {                                                  
        V getValue = (V) cache.get(key);  
        
        if(getValue == null) {
        	Constructor constructor = clazz.getConstructor(key.getClass());
        	V instance = (V) constructor.newInstance(key);
        	cache.put(key, instance);
        	return instance;
        }
         
        return getValue;
    }                                                  
                                                  
    public boolean put(V obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException { 
    	int size = size();
    	try {
	        Method method = obj.getClass().getDeclaredMethod("getKey", null); 
	        method.setAccessible(true);
	        K key = (K) method.invoke(obj, null);
	        cache.put(key, obj);  
    	} catch (Exception e) {
    		return false;
    	}
    	return size < size();
    }                                                  
                                                  
    public int size() {                                                  
        return cache.size();                                                  
    }                                                  
} 