package com.company.students;

public class Student {

    private String name;
    private int course;
    private int id;

    //constructor
    public Student() {
        name = "noName";
        course = -1;
        id = -1;
    }

    //constructor
    public Student(String name, int course, int id) {
        this.name = name;
        this.course = course;
        this.id = id;
    }

    //get method
    public String getName() {
        return name;
    }

    //set method
    public void setName(String name) {
        this.name = name;
    }

    //get method
    public int getCourse() {
        return course;
    }

    //set method
    public void setCourse(int course) {
        this.course = course;
    }

    //get method
    public int getId() {
        return id;
    }

    //set method
    public void setId(int id) {
        this.id = id;
    }

    //to string
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

}
