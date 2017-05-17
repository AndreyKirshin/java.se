package javase02.t05;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UniversityTest {
    private University target =  new University();
    private Student s1 = new Student(1);
    private Student s2 = new Student(2);
    private Student s3 = new Student(3);
    private Student s4 = new Student(4);
    private Student s5 = new Student(5);


    @Before
    public void setUp() throws Exception {

        s1.addDiscipline(Disciplines.MATH);
        s1.setMark(Disciplines.MATH, 6.7);
        s1.addDiscipline(Disciplines.PHILOSOPHY);
        s1.setMark(Disciplines.PHILOSOPHY, 8);

        s2.addDiscipline(Disciplines.MATH);
        s2.setMark(Disciplines.MATH, 3.3);
        s2.addDiscipline(Disciplines.PHYSICS);
        s2.setMark(Disciplines.PHYSICS, 6);

        s3.addDiscipline(Disciplines.MATH);
        s3.setMark(Disciplines.MATH, 9.4);
        s3.addDiscipline(Disciplines.BIOLOGY);
        s3.setMark(Disciplines.BIOLOGY, 4.4);

        s4.addDiscipline(Disciplines.MATH);
        s4.setMark(Disciplines.MATH, 8);
        s4.addDiscipline(Disciplines.PHILOSOPHY);
        s4.setMark(Disciplines.PHILOSOPHY, 2);

        s5.addDiscipline(Disciplines.MATH);
        s5.setMark(Disciplines.MATH, 2.5);
        s5.addDiscipline(Disciplines.PHYSICS);
        s5.setMark(Disciplines.PHYSICS, 3.4);

        target.addStudent(s1);
        target.addStudent(s2);
        target.addStudent(s3);
        target.addStudent(s4);
        target.addStudent(s5);

    }

    @Test
    public void testGetAllStudents() throws Exception {
        List<Student> test = new ArrayList<>();
        test.add(s1);
        test.add(s2);
        test.add(s3);
        test.add(s4);
        test.add(s5);

        assertArrayEquals(target.getAllStudents().toArray(), test.toArray());
    }

    @Test
    public void testGetStudentsByDiscipline() throws Exception {
        List<Student> test = new ArrayList<>();
        test.add(s1);
        test.add(s4);

        assertArrayEquals(target.getStudentsByDiscipline(Disciplines.PHILOSOPHY).toArray(), test.toArray());
    }

    @Test
    public void tesSortAllStudentsByAverageScore() throws Exception {
        List<Student> test = new ArrayList<>();
        test.add(s1);
        test.add(s3);
        test.add(s4);
        test.add(s2);
        test.add(s5);

        assertArrayEquals(target.sortAllStudentsByAverageScore().toArray(), test.toArray());

    }

    @Test
    public void testGetTop3ByDiscipline() throws Exception {
        List<Student> test = new ArrayList<>();
        test.add(s3);
        test.add(s4);
        test.add(s1);

        assertArrayEquals(target.getTop3ByDiscipline(Disciplines.MATH).toArray(), test.toArray());


    }

}