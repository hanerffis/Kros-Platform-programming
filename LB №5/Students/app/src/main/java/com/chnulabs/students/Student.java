package com.chnulabs.students;

import java.util.ArrayList;
import java.util.Arrays;


public class Student {
    private String name;
    private String groupNumber;

    public Student(String name, String groupNumber){
        this.name = name;
        this.groupNumber = groupNumber;
    }

    public String getName(){
        return name;
    }

    public String getGroupNumber(){
        return groupNumber;
    }

    private final static ArrayList<Student> students = new ArrayList<Student>(
            Arrays.asList(
                    new Student("Иван Романов","301"),
                    new Student("Петров Фёдр","301"),
                    new Student("Осачкова Мария","302"),
                    new Student("Косточкин Владисла","302"),
                    new Student("Барабиджан Армен","308"),
                    new Student("Николай Николай","309"),
                    new Student("Базанов Алексей","309"),
                    new Student("Завгородний Антон","309")
            )
    );

    public static ArrayList<Student> getStudents(String groupNumber){
        ArrayList<Student> stList = new ArrayList<>();
        for (Student s: students){
            if (s.getGroupNumber().equals(groupNumber)){
                stList.add(s);
            }
        }
        return stList;
    }
    @Override
    public String toString(){
        return name;
    }
}
