package com.example.eregistrar.repository;

import com.example.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %:searchStr% OR s.middleName LIKE %:searchStr% OR s.lastName LIKE %:searchStr%")
    List<Student> searchStudents(@Param("searchStr") String searchStr);
}

