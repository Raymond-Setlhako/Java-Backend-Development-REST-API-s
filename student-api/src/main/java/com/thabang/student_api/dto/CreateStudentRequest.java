package com.thabang.student_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CreateStudentRequest {

    //adding validation
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @NotBlank(message = "Course cannot be blank")
    private String course;

    private boolean active;

    public CreateStudentRequest() {

    }


    //Getters
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



    //Setters
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
}
