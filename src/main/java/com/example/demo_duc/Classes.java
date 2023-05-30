package com.example.demo_duc;

public class Classes {
    private  int id;
    private  String name;

    public Classes(int id, String name) {
        this.id = id;
        this.name = name;
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
        return "com.example.demo_duc.Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
