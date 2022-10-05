package com.example.myhello;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    private String name;
    private String groupNumber;

    public Student(String name, String groupNumber){
        this.name = name;
        this.groupNumber = groupNumber;
    }

    public String getName() {
        return name;
    }
    public String getGroupNumber() {
        return groupNumber;
    }
    private final static ArrayList<Student> students = new ArrayList<Student>(
            Arrays.asList (
                    new Student ( "IBanOB POMan ",  "301"),
                    new Student ( "IerpOB tegip", "301"),
                    new Student ( "OcaAva oxcaxa" ,  "302"),
                    new Student ( "MaxcMOB Pycnax",  "302"),
                    new Student ( "CMipkoB BaCnAb ",  "308"),
                    new Student ( "oranoBa Mapin",  "309"),
                    new Student ( "ToHCh Kun Inan",  "309"),
                    new Student ( "Bacnnb eB MaxcuM",  "309")
            )
    );
    public static ArrayList<Student> getStudents (String groupNumber){
        ArrayList<Student> stList = new ArrayList<> ();
        for (Student s: students){
            if (s.getGroupNumber().equals (groupNumber)){
                stList.add (s);
            }
        }
        return stList;
    }
}
