package com.thabang.student_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



//Represents a table in the database
@Entity
public class Student {

    //This is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto generate
    private Long id;


    private String name;
    private int age;
    private String course;
    private boolean active;

    //Empty constructor: JPA requires it to create Student objects when reading data from PostgreSQL
    public Student(){

    }

    //Constructor number 2: Useful when we want to create Student objects ourselves
    public Student(Long id, String name, int age, String course, boolean active){
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.active = active;
    }


    //setters: They receive parameters
    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public void setActive(boolean active){
        this.active = active;
    }


    //getters: They do not receive parameters
    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getCourse(){
        return course;
    }

    public boolean isActive(){
        return active;
    }

}
