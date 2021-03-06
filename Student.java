package Lesson_9;

import java.util.List;

public class Student {
    private String name;
    private List<Courses> courses;

    public Student(String name, List<Courses> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Студент " +
                 name +
                " посещает " + courses;
    }
}