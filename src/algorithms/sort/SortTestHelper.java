package algorithms.sort;

import java.lang.reflect.Method;

public class SortTestHelper {

    private SortTestHelper() {}

    /**
     * 生成随机数组
     * 用于生成有 n 个元素的随机整型数组
     * 每个元素的随机范围区间为 [rangeL, rangeR]
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        if (rangeL > rangeR)
            throw new IllegalArgumentException("rangeL must be less then or equal to rangeR");

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
            arr[i] = r;
        }

        return arr;
    }

    /**
     * 生成近乎有序的数组
     * 用于生成一个长度 n 的近乎有序的整型数组
     * swapTimes 定义数据的无序程度
     * 当 swapTimes == 0, 数组完全有序,
     * swapTimes 越大，数组越趋向于无序
     *
     * @param n
     * @param swapTimes
     * @return
     */
    public static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Integer(i);

        // 随机打乱 swapTimes 次位置
        for (int i = 0; i < swapTimes; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            Integer t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        }

        return arr;
    }

    /**
     * 打印数组元素
     *
     * @param arr
     */
    public static void printArray(Object[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 判断数组是否有序
     *
     * @param arr
     * @return
     */
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;

        return true;
    }

    /**
     * 测试排序
     * 执行某种排序算法的测试，传入排序算法类的完整名称（含包名）和测试用数组
     *
     * @param sortClassName
     * @param arr
     */
    public static void testSort(String sortClassName, Comparable[] arr) {

        // Java 反射机制，通过排序的类名，运行排序方法
        try {
            // 通过 sortClassName Class 对象
            Class sortClass = Class.forName(sortClassName);
            // 通过排序方法的 Class 对象获得排序方法
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});
            // 排序参数只有一个，是可比较数组 arr
            Object[] params = new Object[]{arr};

            long startTime = System.currentTimeMillis();
            // 调用排序方法
            sortMethod.invoke(null, params);
            long endTime = System.currentTimeMillis();

            // 判断是否成功排序
            if (!isSorted(arr))
                throw new Exception(sortClass.getSimpleName() + " 排序失败");

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
