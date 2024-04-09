package org.example;
import java.io.*;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.Main.animalList;
import static org.example.Main.iScanner;

public abstract class Animals {
    int id;
    String type;
    String Name;
    Date BirthDate;
    String Commands;


    public Animals(int id, String Name, Date BirthDate, String Commands){
        this.id = id;
        this.Name = Name;
        this.BirthDate = BirthDate;
        this.Commands = Commands;


    }
    public static Animals newAnimal () throws ParseException, IOException {
        System.out.println("Input which animal do you want to add");
        String type = iScanner.nextLine().toLowerCase();
        System.out.println("Input animal's name");
        String name = iScanner.nextLine();
        System.out.println("Input it's birthday like 2020-01-01");
        String BirthDate1 = iScanner.nextLine();;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date BirthDate = dateFormat.parse(BirthDate1);
        System.out.println("Input what commands does it execute");
        String Commands = iScanner.nextLine();
        int id = counter() +1;
        Animals result = new Cat(id, "Noname", BirthDate, "NoCommands");

        switch (type){
            case "dog": result = new Dog( id, name ,BirthDate,Commands);
                break;
            case "hamster": result = new Hamster(id, name, BirthDate, Commands);
                break;
            case "horse": result = new Horse(id, name, BirthDate, Commands);
                break;
            case "camel": result = new Camel(id, name, BirthDate, Commands);
                break;
            case "donkey": result = new Donkey(id, name, BirthDate, Commands);
                break;
            case "cat": result = new Cat(id, name, BirthDate, Commands);
                break;
            default:
                System.out.println("Sorry! You can't add this kind of animals");
                        }
        return result;

    }

    public static void Writer (Animals animal) throws IOException {
        try {
            BufferedWriter writer= new BufferedWriter(new FileWriter("Animal registry", true));
            writer.write(animal.toString());
            writer.write("\n");
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return this.type + " " + this.id+ " " + this.Name + " " + dateFormat.format(this.BirthDate) + " "+ this.Commands + ";";}

    public static int counter() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("Animal registry"))) {
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = Pattern.compile(String.valueOf(";"))
                        .matcher(line);
                if (matcher.find())
                    counter++;
            }

        return counter;}}

    public String getCommands () {
        return this.Commands;
    }

    public static void showCommands (int id, ArrayList<Animals> list){
        Animals animal = animalList.get(findIndex(id, list));
        System.out.println(animal.type +" " + animal.Name + " can " + animal.Commands);

    }

    public static int findIndex(int id, ArrayList<Animals> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id)
                return i;

        }
        return -1;
    }

    public static void addCommand (int id, ArrayList <Animals> list) throws NoSuchFieldException, IllegalAccessException {
        Animals animal = list.get(findIndex(id, list));
        Field field = Animals.class.getDeclaredField("Commands");
        System.out.println("Input new command, that pet has studied");
        String newCommand = animal.Commands + ", " + iScanner.nextLine();
        field.set(animal, newCommand);
        System.out.println("Запись изменена на:");
        System.out.println(animal);
    }

    public static void sortByDate (ArrayList <Animals> list){
        list.sort(new Comparator<Animals>() {
            @Override
            public int compare(Animals o1, Animals o2) {
                if (o2.BirthDate.after(o1.BirthDate)){
                return 1;}
                return -1;
            }
        });
    }

    public static void menu() throws ParseException, IOException, NoSuchFieldException, IllegalAccessException {
        System.out.println("Press:\n1 - if you want watch all animals in registry\n2 - if you want add new animal\n3 - if you want add new command\n4 - if you want know, pet's commands\n5 - for sorting animal's list by date\n6 - for exit menu");
        System.out.print("Put your answer here -->> ");
        String action = iScanner.nextLine();
        switch (action){
            case "1": showAnimals();
                menu();
                break;
            case "2": Animals animal = newAnimal();
                animalList.add(animal);
                Writer(animal);
                menu();
                break;
            case "3":
                System.out.println("Please, input animal id for adding new command");
                int id = Integer.parseInt(iScanner.nextLine());
                addCommand(id, animalList);
                menu();
                break;
            case "4":
                System.out.println("Please, input animal id for watching commands");
                int id2 = Integer.parseInt(iScanner.nextLine());
                showCommands(id2, animalList);
                menu();
                break;
            case "5": sortByDate(animalList);
                showAnimals();
                menu();
                break;
            default: break;
        }
    }

    public static void showAnimals(){
        animalList.forEach(System.out::println);
    }


    }


