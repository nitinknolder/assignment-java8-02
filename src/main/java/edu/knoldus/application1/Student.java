package edu.knoldus.application1;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Student {

    public String name;
    public int rollNumber;
    public Optional<List<String>> subject;

    public Student(String name, int rollNumber, Optional<List<String>> subject) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public Optional<List<String>> getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return ("\nName: " + this.name
                + "\nRoll No: " + this.rollNumber);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return rollNumber == student.rollNumber &&
                Objects.equals(name, student.name) &&
                Objects.equals(subject, student.subject);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, rollNumber, subject);
    }
}
