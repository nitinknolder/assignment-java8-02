package edu.knoldus.application1;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static edu.knoldus.application1.ClassRoomOperations.helloStudent;

public class MainClassRoom {

    public static void main(String [] args) {

        List<String> subject = Arrays.asList("Java8", "Scala", "Spark");
        Optional<List<String>> listOfSubject = Optional.of(subject);

        Student firstName = new Student("Nitin", 11, listOfSubject);
        Student secondName = new Student("Ayush", 12, Optional.empty());
        Student thirdName = new Student("Deepankar", 13,
                Optional.of(Arrays.asList("Java8", "Scala")));

        List<Student> studentList1 = Arrays.asList(firstName, secondName, thirdName);
        List<Student> studentList2 = Arrays.asList(firstName, secondName);
        ClassRoom classRoom1 = new ClassRoom(11, Optional.of(studentList1));
        ClassRoom classRoom2 = new ClassRoom(12, Optional.of(studentList2));

        System.out.println(ClassRoomOperations.getStudentsWitNoSubjects(classRoom1));
        helloStudent(classRoom1);
        List<ClassRoom> classRoom = Arrays.asList(classRoom1, classRoom2);
        ClassRoomOperations.getSubjectLinkWithRoomId(2, classRoom);

    }
}