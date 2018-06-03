package com.cphayim.test;

import com.cphayim.ds.Array;

/**
 * @author Cphayim
 * @date Created in 2018/6/3 20:13
 */
public class ArrayTest {
    public static void main(String[] args) {

        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        Array<Student> students = new Array<>();
        students.addLast(new Student("Cphayim", 85));
        students.addLast(new Student("Hoyoe", 100));
        students.addLast(new Student("Mammon", 59));

        System.out.println(students);
    }
}
