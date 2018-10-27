package algorithms.sort;

/**
 * 希尔排序
 */
public class ShellSort {

    private ShellSort() {}

    public static void sort(Comparable[] arr) {

        // 增量
        int h = arr.length / 2;

        do {
            for (int i = h; i < arr.length; i++) {

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]...使用插入排序
                Comparable e = arr[i];
                int j;
                for (j = i; j >= h && e.compareTo(arr[j-h]) < 0; j -= h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = e;
            }

            h /= 2;
        } while (h > 0);
    }

    public static void main(String[] args) {
        int n = 30000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100000);
        SortTestHelper.testSort(ShellSort.class.getName(), arr);
    }
}
