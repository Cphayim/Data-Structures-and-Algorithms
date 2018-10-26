package algorithms.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    private SelectionSort() {}

    public static void sort(Comparable[] arr) {

        for (int i = 0; i < arr.length; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++)
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;

            // 交换最小值和索引为i的值的位置
            swap(arr, i, minIndex);
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
        SortTestHelper.testSort(SelectionSort.class.getName(), arr);
    }
}
