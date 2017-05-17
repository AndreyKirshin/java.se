package javase02.t05;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Student {
    final static AverageScoreComparator averageScoreComparator = new AverageScoreComparator();
    private int studentsId;
    private Map<Disciplines, Number> disciplinesAndMarks = new HashMap<>();

    public Student(int studentsId) {
        this.studentsId = studentsId;

    }

    public void addDiscipline(Disciplines dis) {
        disciplinesAndMarks.putIfAbsent(dis, null);
    }

    /**
     * Sets mark by discipline. Mark is int if discipline is Biology or Philosophy, is float in other cases
     * Marks are stored in the map as Number
     *
     * @param dis discipline
     * @param mark mark by discipline
     */
    public void setMark(Disciplines dis, Number mark) {
        if (disciplinesAndMarks.containsKey(dis)) {
            switch (dis){
                case BIOLOGY:
                case PHILOSOPHY:
                    mark = Math.abs(mark.intValue());
                    break;
                default: mark = Math.abs(mark.floatValue());
            }
            disciplinesAndMarks.put(dis, mark);
        }
    }

    @Override
    public String toString() {
    StringBuffer sb = new StringBuffer();
        sb.append("Student #" + studentsId + " ");
        for(Disciplines d : disciplinesAndMarks.keySet()) {
            sb.append(d.toString() + " ");
            if (null == disciplinesAndMarks.get(d)) {
                sb.append("null ");
            } else {
                sb.append(new DecimalFormat("#0.0").format(disciplinesAndMarks.get(d).floatValue()) + " ");
            }
        }
        sb.append("Average Score " + new DecimalFormat("#0.0").format(getAverageScore()));
        return sb.toString();
    }

    public Number getMark(Disciplines dis) {
        return disciplinesAndMarks.get(dis);
    }

    public boolean isAttendsDiscipline(Disciplines dis){
        return disciplinesAndMarks.containsKey(dis);
    }

    public float getAverageScore() {
        Float sum = 0f;

        for(Number n : disciplinesAndMarks.values()) {
            if(null == n) {
                System.out.println("Get mark for all disciplines!!!");
                return 0;
            }
            else
                sum = sum + n.floatValue();
        }
        return sum/disciplinesAndMarks.size();
    }

    private static class AverageScoreComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.getAverageScore() < s2.getAverageScore() ? 1 : s1.getAverageScore() == s2.getAverageScore() ? 0 : -1;
        }
    }
}

