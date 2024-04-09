package org.example;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static org.example.Animals.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner iScanner = new Scanner(System.in);
    static ArrayList<Animals> animalList = new ArrayList();

    public static void main(String[] args) throws ParseException, IOException, NoSuchFieldException, IllegalAccessException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        animalList.add(new Dog(1, "Fido", df.parse("2020-01-01"), "Sit, Stay, Fetch"));
        animalList.add(new Cat(2, "Whiskers", df.parse("2019-05-15"), "Sit, Pounce"));
        animalList.add(new Hamster(3, "Hammy", df.parse("2021-03-10"), "Roll, Hide;"));
        animalList.add(new Horse(4, "Thunder", df.parse("2015-07-21"), "Trot, Canter, Gallop"));
        animalList.add(new Camel(5, "Sandy", df.parse("2016-11-03"), "Walk, Carry Load"));
        animalList.add(new Donkey(6, "Eeyore", df.parse("2017-09-18"), "Walk, Carry Load, Bray"));
        animalList.add(new Dog(7, "Buddy", df.parse("2018-12-10"), "Sit, Paw, Bark"));
    Animals.menu();


        }

    }








