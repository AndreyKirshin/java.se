package javase02.t05;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Student {
    private int studentsId;
    private Map<Disciplines, Number> disciplinesHashMap = new HashMap<>();
    private float averageScore;
    final static AverageScoreComparator averageScoreComparator = new AverageScoreComparator();

    public Student(int studentsId) {
        this.studentsId = studentsId;

        /** Math and Physic score is float, Biology and Philosophy score is int
         *
         */
        int i = 0;
        while (i < 3) {
            int disNum = new Random().nextInt(4);
            Disciplines dis = Disciplines.values()[disNum];
            if(!disciplinesHashMap.containsKey(dis)) {
                if (disNum < 2) {
                    float ball = new Random().nextFloat() * 10;
                    disciplinesHashMap.put(dis, ball);
                } else {
                    int ball = new Random().nextInt(11);
                    disciplinesHashMap.put(dis, ball);
                }
                i++;
            }
        }
        averageScore = calculateAverageScore();
    }

    @Override
    public String toString() {
    StringBuffer sb = new StringBuffer();
        sb.append("Student #" + studentsId + " ");
        for(Disciplines d : disciplinesHashMap.keySet()) {
            sb.append(d.toString() + " " + new DecimalFormat("#0.0").format(disciplinesHashMap.get(d)) + " ");
        }
        sb.append("Average Score " + new DecimalFormat("#0.0").format(averageScore));
        return sb.toString();
    }

    private float calculateAverageScore() {
        float averageScore = 0;
        for(Disciplines d : disciplinesHashMap.keySet()) {
            if(disciplinesHashMap.get(d) instanceof Integer) {
               int l = (int) disciplinesHashMap.get(d);
               averageScore += l;
            } else {
                averageScore += (float) disciplinesHashMap.get(d);
            }
        }
        averageScore = new BigDecimal(averageScore/3).setScale(10, BigDecimal.ROUND_HALF_UP).floatValue();
        return averageScore;
    }

    public Map<Disciplines, Number> getDisciplinesHashMap() {
        return disciplinesHashMap;
    }

    private static class AverageScoreComparator implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return s1.averageScore < s2.averageScore ? 1 : s1.averageScore == s2.averageScore ? 0 : -1;
        }
    }
}

