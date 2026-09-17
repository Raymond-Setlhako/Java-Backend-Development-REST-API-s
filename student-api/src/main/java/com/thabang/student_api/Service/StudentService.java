package com.thabang.student_api.Service;

import com.thabang.student_api.dto.CreateStudentRequest;
import com.thabang.student_api.exception.StudentNotFoundException;
import com.thabang.student_api.model.Student;
import com.thabang.student_api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


//This class contains application/business logic
@Service
public class StudentService {

    //Connecting the service to the repository
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    //Creating a method that returns student
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));
    }

    public Student createStudent(CreateStudentRequest request){

        Student student = new Student(
                null,
                request.getName(),
                request.getAge(),
                request.getCourse(),
                request.isActive()

        );

        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updateStudent) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student with ID " + id + " not found"));

    existingStudent.setName(updateStudent.getName());
    existingStudent.setAge(updateStudent.getAge());
    existingStudent.setCourse(updateStudent.getCourse());
    existingStudent.setActive(updateStudent.isActive());

    return studentRepository.save(existingStudent);
    }

    //Method to delete student
    public void deleteStudent(Long id){

        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student with id " + id + " not found"));

        studentRepository.delete(existingStudent);
    }
}
