package com.thabang.student_api.controller;

import com.thabang.student_api.Service.StudentService;
import com.thabang.student_api.dto.CreateStudentRequest;
import com.thabang.student_api.model.Student;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//The controller handles the HTTP side
@RestController
public class StudentController {

    //We are connecting the controller to the service
    private final StudentService studentService;

    //Adding a constructor
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //This tells spring that when a client sends a GET request to students, run this method
    // GET /student
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    //Get using student id
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    //Using post to create new student
    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
        public Student createStudent(@Valid @RequestBody CreateStudentRequest request){
            return studentService.createStudent(request);
        }

    //Using PUT to update student data
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    //Using Delete to delete student data
    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    //using void because we are not returning the deleted student
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
