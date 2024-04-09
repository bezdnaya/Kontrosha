package org.example;

import java.util.Date;

public class Hamster extends Pets{

    public Hamster (int id, String Name, Date BirthDate, String Commands){
        super (id, Name, BirthDate, Commands);
        this.type = "Hamster";

    }
}