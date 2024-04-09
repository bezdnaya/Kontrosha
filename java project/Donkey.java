package org.example;

import java.util.Date;

public class Donkey extends PackAnimals{

    public Donkey(int id, String Name, Date BirthDate, String Commands){
        super (id, Name, BirthDate, Commands);
        this.type = "Donkey";

    }
}
