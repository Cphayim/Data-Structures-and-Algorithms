package com.cphayim.test.array;

/**
 * @author Cphayim
 * @date Created in 2018/6/3 21:00
 */
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}
