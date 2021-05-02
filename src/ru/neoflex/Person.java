package ru.neoflex;

import java.io.*;

public class Person implements Serializable {
    private String name;
    private int age;
    private transient String password;
    public final static String type = "Human";

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Person { " +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", password = '" + password + '\'' +
                '}';
    }


}
