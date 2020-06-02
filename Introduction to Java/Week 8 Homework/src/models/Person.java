package models;

import java.util.List;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int age;
    private char type;


    public Person(String firstName, String lastName, int age, char type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public char getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("| Type: %s |First Name: %s | Last Name: %s | Age: %d",this.getType(),this.getFirstName(),this.getLastName(),this.getAge());
    }
}
