package com.thabang.student_api.repository;


import com.thabang.student_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//We are telling JPA to create a repository for the student entity, where primary key is Long
public interface StudentRepository extends JpaRepository<Student, Long> {
}
