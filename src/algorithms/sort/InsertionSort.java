package algorithms.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    private InsertionSort() {}

    public static void sort(Comparable[] arr) {
        /*
        // 写法一
        for (int i = 1; i < arr.length; i++) {
            // 寻找元素 arr[i] 合适的插入位置
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0)
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
        */

        /*
        // 写法二
        for (int i = 1; i < arr.length; i++)
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--)
                swap(arr, j, j - 1);
        */

        // 优化算法，减少对数组元素的赋值操作
        /*
        for (int i = 1; i < arr.length; i++) {
            Comparable e = arr[i];
            int j; // j 保存元素 e 应该插入的位置
            for (j = i; j > 0 && e.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
        */

        sort(arr, 0, arr.length - 1);
    }

    /**
     * 对 arr[l...r] 进行插入排序
     *
     * @param arr
     * @param l
     * @param r
     */
    public static void sort(Comparable[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j; // j 保存元素 e 应该插入的位置
            for (j = i; j > l && e.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
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
        SortTestHelper.testSort(InsertionSort.class.getName(), arr);
    }
}
