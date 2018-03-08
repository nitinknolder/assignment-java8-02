package edu.knoldus.application1;

import java.util.List;
import java.util.Optional;

public class ClassRoom {
    int roomId;
    Optional<List<Student>> studentList;


    public ClassRoom(int roomId, Optional<List<Student>> studentList) {
        this.roomId = roomId;
        this.studentList = studentList;
    }

    public int getRoomId() {

        return roomId;
    }

    public Optional<List<Student>> getStudentList() {
        return studentList;
    }
}
