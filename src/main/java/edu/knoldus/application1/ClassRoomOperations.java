package edu.knoldus.application1;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClassRoomOperations {


    public static Optional<List<Student>> getStudentsWitNoSubjects(ClassRoom classRoomObject) {

        return classRoomObject.getStudentList().map(classList -> classList.stream()
                .filter(student -> !student.getSubject().isPresent())
                .collect(Collectors.toList()));
    }

    public static void getSubjectLinkWithRoomId(int roomId, List<ClassRoom> classRoomObject) {

        classRoomObject.stream().filter(id -> id.getRoomId() == roomId).map(id -> id.getStudentList().get())
                .flatMap(subjects -> subjects.stream().map(s -> s.getName() + s.getSubject()))
                .forEach(System.out::print);
    }

    public static void helloStudent(ClassRoom classRoomObject) {
        if (classRoomObject.getStudentList().isPresent()) {
            List<Student> studentList = classRoomObject.getStudentList().get();
            studentList.forEach(studentName -> System.out.println("Hello: " + studentName));
        }
    }


}
