package com.example.demo_duc;

import java.util.ArrayList;
import java.util.List;

public class ClassesManage {
    private static ClassesManage classesManage;
    List<Classes> classesList;
    private ClassesManage(){
        classesList=new ArrayList<>();
        classesList.add(new Classes(1, "12A"));
        classesList.add(new Classes(2, "12B"));
        classesList.add(new Classes(3, "12C"));

    }
    public static ClassesManage getInstance(){
        if(classesManage==null){
            classesManage=new ClassesManage();
        }
        return classesManage;
    }

    public static ClassesManage getClassesManage() {
        return classesManage;
    }

    public static void setClassesManage(ClassesManage classesManage) {
        ClassesManage.classesManage = classesManage;
    }

    public List<Classes> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classes> classesList) {
        this.classesList = classesList;
    }
    public Classes getClasses(String name){
        for (Classes c:classesList) {
            if(c.getName().equals(name)){
                return c;
            }
        }return null;
    }
}
