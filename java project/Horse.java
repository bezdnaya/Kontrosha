package org.example;

import java.util.Date;

public class Horse extends PackAnimals{

    public Horse (int id, String Name, Date BirthDate, String Commands){
        super (id, Name, BirthDate, Commands);
        this.type = "Horse";

    }
}
