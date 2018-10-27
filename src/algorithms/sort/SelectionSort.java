package algorithms.sort;

/**
 * 选择排序
 */
public class SelectionSort {

    private SelectionSort() {}

    public static void sort(Comparable[] arr) {

        /*
        for (int i = 0; i < arr.length; i++) {
            // 寻找[i, n)区间里的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++)
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;

            // 交换最小值和索引为i的值的位置
            swap(arr, i, minIndex);
        }
        */

        // 优化算法，双路查找
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int minIndex = left;
            int maxIndex = right;

            // 在每一轮查找时，要保证 arr[minIndex] <= arr[maxIndex]
            if (arr[minIndex].compareTo(arr[maxIndex]) > 0)
                swap(arr, minIndex, maxIndex);

            for (int i = left + 1; i < right; i++) {
                if (arr[i].compareTo(arr[minIndex]) < 0)
                    minIndex = i;
                else if (arr[i].compareTo(arr[maxIndex]) > 0)
                    maxIndex = i;
            }

            swap(arr, left, minIndex);
            swap(arr, right, maxIndex);

            left++;
            right--;
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
