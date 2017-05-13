package javase02.t05;

import java.util.HashMap;

public class Student<V extends Number> {
    private String name;
    private HashMap<Disciplines, V> disciplinesHashMap;

    public Student(String name, HashMap<Disciplines, V> disciplinesHashMap) {
        this.name = name;
        this.disciplinesHashMap = disciplinesHashMap;
    }

}

enum Disciplines {
    PHYSICS,
    MATH,
    BIOLOGY,
    PHILOSOPHY,


}
