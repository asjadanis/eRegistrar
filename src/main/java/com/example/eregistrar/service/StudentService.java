package com.example.eregistrar.service;

import com.example.eregistrar.model.Student;
import com.example.eregistrar.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository stdRepo;

    public StudentService(StudentRepository stdRepo) {
        this.stdRepo = stdRepo;
    }

    public Optional<Student> getStudentById(long id) {
        return stdRepo.findById(id);
    }

    public Collection<Student> getAllStudents() {
        return stdRepo.findAll();
    }

    public void addStudent(Student std) {
        stdRepo.save(std);
    }

    public void deleteStudent(long id) {
        Student std = stdRepo.findById(id).orElse(null);
        if(Objects.nonNull(std)){
            stdRepo.delete(std);
        }else{
            throw new EntityNotFoundException();
        }
    }

    public void updateStudent(Student std) {
        Student existingStd = stdRepo.findById(std.getId()).orElse(null);
        if(Objects.nonNull(existingStd)) {
            stdRepo.save(std);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<Student> searchStd(String searchStr) {
        return stdRepo.searchStudents(searchStr);
    }
}
