package javase02.t05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class University {
    private static final int numberOfStudents = 10;
    private List<Student> generalListOfStudents = new ArrayList<>();

    public University() {
        System.out.println("General list of students:");
        for (int i = 0; i < numberOfStudents; i++) {
            generalListOfStudents.add(new Student(i));
            System.out.println(generalListOfStudents.get(i));
        }
        System.out.println("======================");
    }
    
    public List<Student> createDisciplineList(Disciplines dis){
        List<Student> disciplineList = new ArrayList<>();
        for(Student s : generalListOfStudents) {
            if(s.getDisciplinesHashMap().containsKey(dis)) {
                disciplineList.add(s);
            }
        }
        printList(disciplineList);
        return disciplineList;
    }

    private void printList(List<Student> list) {
        for (Student s : list) {
            System.out.println(s);
        }
        System.out.println("==END OF THE LIST==");
    }

    public void sortByAverageScore() {
        Collections.sort(generalListOfStudents, Student.averageScoreComparator);
        printList(generalListOfStudents);
    }

    public static void main(String[] args) {

        University u1 = new University();
        List<Student> list = u1.createDisciplineList(Disciplines.BIOLOGY);
        u1.sortByAverageScore();
    }
}
