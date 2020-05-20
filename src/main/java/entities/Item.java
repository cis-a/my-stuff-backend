package entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Item { 
	
    Long id;
    
    String name;
    
    int amount;
    
    String location;
    
    String description;
    
    Date lastUsed;

}
