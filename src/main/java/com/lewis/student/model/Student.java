package com.lewis.student.model;

public class Student {
    private String name;
    private String rollNumber;
    private String gender;

    public Student(){}

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public Student(String name, String rollNumber, String gender) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
