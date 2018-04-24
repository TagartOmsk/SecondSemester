package ru.omsu.imit.collections;

public class Student extends Human{
    protected String facultyName;

    public Student(String name, String surname, int age, String facultyName) {
        super(name, surname, age);
        this.facultyName = facultyName;
    }

    public Student(String name, String surname, String patronym, int age, String facultyName) {
        super(name, surname, patronym, age);
        this.facultyName = facultyName;
    }
}
