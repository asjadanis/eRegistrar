package com.example.eregistrar.controller;

import com.example.eregistrar.model.Student;
import com.example.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/eregistrar/student")
public class StudentController {
    @Autowired
    private StudentService stdService;




    @GetMapping("")
    public String searchStudents(@RequestParam(name = "search", required = false) String searchStr, Model model) {

        if (searchStr == null || searchStr.isEmpty()) {
            List<Student> students = (List<Student>) stdService.getAllStudents();
            model.addAttribute("students", students);
            model.addAttribute("pageTitle", "Students");
        }
        List<Student> students = (List<Student>) stdService.searchStd(searchStr);
        model.addAttribute("students", students);
        model.addAttribute("pageTitle", "Students");
        return "student";
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudent(@PathVariable long studentId){
        Optional<Student> optionalStudent = stdService.getStudentById(studentId);

        if (optionalStudent.isPresent()) {
            return new ResponseEntity<>(optionalStudent.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        stdService.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student student){
        Optional<Student> existingStudent = stdService.getStudentById(studentId);

        if (existingStudent.isPresent()) {
            stdService.updateStudent(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long studentId){
        Optional<Student> existingStudent = stdService.getStudentById(studentId);

        if (existingStudent.isPresent()) {
            stdService.deleteStudent(studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
