package com.example.eregistrar.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "std-number", nullable = false)
    private String studentNumber;
    @Column(name = "First Name", nullable = false)
    private String firstName;
    @Column(name = "Middle Name", nullable = false)
    private String middleName;
    @Column(name = "Last Name", nullable = false)
    private String lastName;
    @Column(name = "GPA", nullable = false)
    private float gpa;

    @Temporal(TemporalType.DATE)
    private String enrollmentDate;

    @Column(name = "Is International", nullable = false)
    private String isInternational;

    public Student() {
    }

    public Student(long id, String studentNumber, String firstName, String middleName, String lastName, float gpa, String enrollmentDate, String isInternational) {
        this.id = id;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(String isInternational) {
        this.isInternational = isInternational;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gpa=" + gpa +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                ", isInternational='" + isInternational + '\'' +
                '}';
    }



}
