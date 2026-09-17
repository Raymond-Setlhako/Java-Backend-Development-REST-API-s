package com.thabang.student_api.exception;

//Creating our own type of exception for our application
public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException (String message){
        super(message);
    }
}
