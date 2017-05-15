package javase02.t05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    private Student target = new Student(12);

    @Before
    public void init() {
        target.addDiscipline(Disciplines.BIOLOGY);
        target.addDiscipline(Disciplines.PHYSICS);

        target.setMark(Disciplines.BIOLOGY, 5.14);
        target.setMark(Disciplines.PHYSICS, 6.3);
    }

    @Test
    public void testGetMark() throws Exception {

        assertEquals(target.getMark(Disciplines.BIOLOGY), 5);
        assertEquals(target.getMark(Disciplines.PHYSICS), 6.3);

    }


    @Test
    public void testIsAttendsDiscipline() throws Exception {
        assertTrue(target.isAttendsDiscipline(Disciplines.BIOLOGY));
        assertFalse(target.isAttendsDiscipline(Disciplines.MATH));
    }

    @Test
    public void testGetAverageScore() throws Exception {
        assertEquals(target.getAverageScore(), 5.650000095367432, 0.01);
    }

    @Test
    public void testGetAverageScoreIfOneMarksIsNull() throws Exception {
        target.addDiscipline(Disciplines.MATH);
        assertEquals(target.getAverageScore(), 0, 0.01);
    }
}