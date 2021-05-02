package ru.neoflex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HomeWork {
    private static String path = ".\\Persons.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Иван", 25, "qwerty"));
        people.add(new Person("Петр", 21, "йцукен"));
        people.add(new Person("Юра", 35, "adz"));
        people.add(new Person("Женя", 45, "111"));
        people.add(new Person("Коля", 56, "12345"));

        people.forEach(System.out::println);
        System.out.println();
        var dataFile = new File(path);
        saveToFile(people, dataFile);

        List<Person> people2 = readFromFile(dataFile);
        System.out.println("Список после чтения из файла: " + "\n");
        people2.forEach(System.out::println);
    }

    private static void saveToFile(List<Person> people, File dataFile) throws IOException {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {
            for (Person peoples : people)
                out.writeObject(peoples);
        }
    }

    static List<Person> readFromFile(File dataFile) throws IOException,
            ClassNotFoundException {
        var personArrayList = new ArrayList<Person>();
        try (var in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(dataFile)))) {
            while (true) {
                var object = in.readObject();
                if (object instanceof Person) personArrayList.add((Person) object);

            }
        } catch (EOFException e) {
            System.out.println("Файл прочитан полностью"); // File end reached
        }
        return personArrayList;
    }

}
