import edu.knoldus.application1.ClassRoom;
import edu.knoldus.application1.ClassRoomOperations;
import edu.knoldus.application1.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class TestingApplication1 {

    private static List<Student> listOfStudents;
    private static List<String> listOfSubject;
    private static ClassRoom myClassRoom;
    private static ClassRoom storeRoom;
    private static Student student;
    private static ClassRoom room;
    private List<Student> list = new ArrayList<>();

    @BeforeClass
    public static void Configurations() {

        listOfSubject = new ArrayList();
        listOfSubject.add("Java8");
        listOfSubject.add("Scala");
        listOfSubject.add("Spark");

        student = new Student("Nitin", 11, Optional.of(listOfSubject));

        listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student("Nitin", 11, Optional.of(listOfSubject)));
        listOfStudents.add(new Student("Ayush", 12, Optional.empty()));
        listOfStudents.add(new Student("Deepankar", 13, Optional.of(listOfSubject)));

        myClassRoom = new ClassRoom(1, Optional.of(listOfStudents));
        storeRoom = new ClassRoom(2, Optional.empty());
        room = new ClassRoom(11, Optional.of(listOfStudents));
    }

    @Test
    public final void testClassRoomId() {
        int actualResult = myClassRoom.getRoomId();
        int expectedResult = 1;
        assertEquals("Room Id must be 1",
                expectedResult, actualResult);
    }

    @Test
    public final void testGetStudents() {
        assertEquals("Room must have students",
                myClassRoom.getStudentList().isPresent(), true);
    }

    @Test
    public final void testGetStudentsStoreRoom() {
        assertEquals("Store Room must not have students",
                storeRoom.getStudentList().isPresent(), false);
    }


    @Test
    public final void testGetStudentsWithNoSubject() {
        Stream<Student> expectedResult =
                listOfStudents.stream();
        assertArrayEquals("Room 1 has Only one student with no subjects",
                myClassRoom.getStudentList().get().toArray(), expectedResult.toArray());
    }

    @Test
    public final void testGetName() {
        assertEquals("Get the Name: ", student.getName(), "Nitin");
    }

    @Test
    public final void testGetRollNumber() {
        assertEquals("Get the Name: ", student.getRollNumber(), 11);
    }

    @Test
    public void getSubject() {
        assertEquals("get Subject Name: ", student.getSubject(), Optional.of(listOfSubject));
    }

    @Test
    public final void testGetRoomId() {
        assertEquals("Get Room Id : 11", room.getRoomId(), 11);
    }

    @Test
    public final void testGetStudentList() {
        assertEquals("Get StudentList", room.getStudentList(), Optional.of(listOfStudents));
    }

    @Test
    public final void getToStringName() {

        assertEquals("Get Student Name", student.getName(), "Nitin");
    }

    @Test
    public final void getToStringRollNumber() {

        assertEquals("Get Student RollNo", student.getRollNumber(), 11);
    }

    @Test
    public final void getToString() {

        assertEquals("Get Student RollNo", student.toString(), "\nName: " + student.name
                + "\nRoll No: " + student.getRollNumber());
    }

    @Test
    public final void getStudentWithNoSubject() {
        list.add(new Student("Ayush", 12, Optional.empty()));
        assertEquals("Get All Subjects", list,
                ClassRoomOperations.getStudentsWitNoSubjects(myClassRoom).get());
    }
}


