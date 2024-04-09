package org.example;

import java.util.Date;

public class Dog extends Pets{

    public Dog (int id, String Name, Date BirthDate, String Commands){
        super (id, Name, BirthDate, Commands);
        this.type = "Dog";

    }
}
