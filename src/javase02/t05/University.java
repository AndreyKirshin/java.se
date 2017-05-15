package javase02.t05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    private List<Student> allStudents = new ArrayList<>();

    /**
     * Creates list of students are studying discipline
     *
     * @param dis name of the discipline
     * @return created list
     */
    public List<Student> getStudentsByDiscipline(Disciplines dis) {
        return allStudents
                .stream()
                .filter(student -> student.isAttendsDiscipline(dis))
                .collect(Collectors.toList());
    }

    private static void printStudents(List<Student> list) {
        list.forEach(System.out::println);
        System.out.println("==END OF THE LIST==");
    }

    public List<Student> getStudentsSortedByAverageScore() {
        return allStudents
                .stream()
                .sorted(Student.averageScoreComparator)
                .collect(Collectors.toList());
    }

    /**
     * Creates list of the 5 best students in concrete discipline
     *
     * @param dis name of the discipline
     * @return created list
     */
    public List<Student> getTop5ByDiscipline(Disciplines dis) {

        return getStudentsByDiscipline(dis)
                .stream()
                .sorted((s1, s2) -> s1.getMark(dis).floatValue() < s2.getMark(dis).floatValue()
                        ? 1 : s1.getMark(dis).floatValue() == s2.getMark(dis).floatValue()
                        ? 0 : -1)
                .limit(5)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        University u1 = new University();
        //List<Student> list = u1.getStudentsByDiscipline(Disciplines.BIOLOGY);
        //u1.sortByAverageScore();
//        List<Student> theBestFivePhis = u1.getTop5ByDiscipline(Disciplines.PHYSICS);
//        University.printStudents(theBestFivePhis);
        //printStudents(u1.getStudentsSortedByAverageScore());
    }
}
