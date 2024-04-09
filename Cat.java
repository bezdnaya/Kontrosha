package org.example;

import java.util.Date;

public class Cat extends Pets{

    public Cat (int id, String Name, Date BirthDate, String Commands){
        super (id, Name, BirthDate, Commands);
        this.type = "Cat";

    }

}
