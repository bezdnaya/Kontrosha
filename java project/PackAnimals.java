package org.example;

import java.util.Date;

public abstract class PackAnimals extends Animals {
    public PackAnimals (int id, String Name, Date BirthDate, String Commands){
        super (id, Name, BirthDate, Commands);
        this.type = "Pack animals";
    }
}
