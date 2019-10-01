package com.company.students;

public class Student {

    private String name;
    private int course;
    private int id;

    public Student() {
        name = "noName";
        course = -1;
        id = -1;
    }

    public Student(String name, int course, int id) {
        this.name = name;
        this.course = course;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                '}';
    }
}
