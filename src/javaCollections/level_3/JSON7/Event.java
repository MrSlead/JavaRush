package javaCollections.level_3.JSON7;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;                                                  

public class Event {                                                  
    public String name;                                                  
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    public Date eventDate;                                                  
                                                  
    public Event(String name) {                                                  
        this.name = name;                                                  
        eventDate = new Date();                                                  
    }                                                  
}