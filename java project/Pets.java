package org.example;

import java.util.Date;

public abstract class Pets extends Animals {
    public Pets (int id, String Name, Date BirthDate, String Commands){
        super (id, Name, BirthDate, Commands);
        this.type = "Pets";

    }
}
