package algorithms.sort;

public class BubbleSort {

    private BubbleSort() {}

    public static void sort(Comparable[] arr) {
        /*
        // 写法一
        int n = arr.length;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i].compareTo(arr[i - 1]) < 0) {
                    swap(arr, i, i - 1);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
        */

        // 写法二
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    public static void swap(Object[] arr, int x, int y) {
        Object t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    public static void main(String[] args) {
        int n = 30000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100000);
        SortTestHelper.testSort(BubbleSort.class.getName(), arr);
    }
}
