package algorithms.sort;

import java.util.Arrays;

public class SortTest {

    static final int N = 30000;

    public static void main(String[] args) {

        // 需要测试的排序算法类
        Class[] sortClassArray = {
                BubbleSort.class,
                SelectionSort.class,
                InsertionSort.class
        };
        start(sortClassArray);
    }

    public static void start(Class[] sortClassArray) {

        standardTest(sortClassArray);
        highRepetitionTest(sortClassArray);
        nearlyOrderedTest(sortClassArray);
    }

    /**
     * 一般性的排序测试
     *
     * @param sortClassArray
     */
    public static void standardTest(Class[] sortClassArray) {

        System.out.println("一般性的排序测试：");
        Integer[] originalArr = SortTestHelper.generateRandomArray(N, 0, 100000);
        for (Class sortClass : sortClassArray) {
            Integer[] newArr = Arrays.copyOf(originalArr, originalArr.length);
            SortTestHelper.testSort(sortClass.getName(), newArr);
        }
    }

    /**
     * 高重复数组的排序测试
     *
     * @param sortClassArray
     */
    public static void highRepetitionTest(Class[] sortClassArray) {

        System.out.println("高重复数组的排序测试：");
        Integer[] originalArr = SortTestHelper.generateRandomArray(N, 0, 1);
        for (Class sortClass : sortClassArray) {
            Integer[] newArr = Arrays.copyOf(originalArr, originalArr.length);
            SortTestHelper.testSort(sortClass.getName(), newArr);
        }
    }

    /**
     * 近乎有序数组的测试
     *
     * @param sortClassArray
     */
    public static void nearlyOrderedTest(Class[] sortClassArray) {

        System.out.println("近乎有序数组的测试：");
        Integer[] originalArr = SortTestHelper.generateNearlyOrderedArray(N, 100);
        for (Class sortClass : sortClassArray) {
            Integer[] newArr = Arrays.copyOf(originalArr, originalArr.length);
            SortTestHelper.testSort(sortClass.getName(), newArr);
        }
    }
}
