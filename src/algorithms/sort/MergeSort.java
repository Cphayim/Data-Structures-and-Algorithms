package algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    private MergeSort() {}

    public static void sort(Comparable[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用归并排序，对arr[l...r]的范围进行排序
     *
     * @param arr
     * @param l
     * @param r
     */
    private static void sort(Comparable[] arr, int l, int r) {

        // ①
        // if (l >= r) return;

        // ① 优化算法
        // 当 [l, r] 区间很小时，通常意味着数组中有更多的元素是有序的
        // 转而使用插入排序（最佳情况 O(n)）
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }

        int mid = (l + r) / 2;

        // 分别对 arr[l...mid] 和 arr[mid+1...r] 进行排序
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        // ②
        // 对左右已排序数组进行归并
        // merge(arr, l, mid, r);

        // ② 优化算法
        // 由于在上面的两次递归中对 arr[l...mid] 和 arr[mid+1...r] 进行了排序
        // 当 arr[mid] <= arr[mid+1] 时，说明 arr[l...r] 已经有序
        if (arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        // 临时数组，拷贝原数组 [l, r]，其 x 索引对应原数组的 x+l 索引
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j 指向右半部分的起始索引位置mid+1
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {

            // 如果左半部分已经全部处理完毕
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            }
            // 如果右半部分已经全部处理完毕
            else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            }
            // 左半部分所指元素 < 右半部分所指元素
            else if (aux[i - l].compareTo(aux[j - l]) < 0) {
                arr[k] = aux[i - l];
                i++;
            }
            // 左半部分所指元素 >= 右半部分所指元素
            else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int n = 30000;
        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 100000);
        SortTestHelper.testSort(MergeSort.class.getName(), arr);
    }
}
