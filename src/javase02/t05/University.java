package javase02.t05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    private List<Student> allStudents = new ArrayList<>();

    public void addStudent(Student s) {
        allStudents.add(s);
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

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


    public List<Student> sortAllStudentsByAverageScore() {
        return allStudents
                .stream()
                .sorted(Student.averageScoreComparator)
                .collect(Collectors.toList());
    }

    /**
     * Creates list of the 3 best students in concrete discipline
     *
     * @param dis name of the discipline
     * @return created list
     */
    public List<Student> getTop3ByDiscipline(Disciplines dis) {

        return getStudentsByDiscipline(dis)
                .stream()
                .sorted((s1, s2) -> s1.getMark(dis).floatValue() < s2.getMark(dis).floatValue()
                        ? 1 : s1.getMark(dis).floatValue() == s2.getMark(dis).floatValue()
                        ? 0 : -1)
                .limit(3)
                .collect(Collectors.toList());
    }
}
