package com.erasmus.task1;

/**
 * Created by zankowitch on 26/10/16.
 */
public class Human {
    private String name,surname;

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(Human H1){
        this.name = H1.getName();
        this.surname = H1.getSurname();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "name: " + name + ", surname: " + surname + ".";
    }
}
