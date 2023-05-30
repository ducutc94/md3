package com.example.demo_duc;

public class Students {
    private int id;
    private String name;
    private Classes classes;
    public Students(){

    }

    public Students(int id, String name, Classes classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", class='" + classes.getName() + '\'' +

                '}';
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
