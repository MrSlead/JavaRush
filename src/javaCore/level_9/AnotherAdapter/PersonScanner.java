package javaCore.level_9.AnotherAdapter;

import java.io.IOException;                                                  

public interface PersonScanner {                                                  
    Person read() throws IOException;                                                  
                                                  
    void close() throws IOException;                                                  
}