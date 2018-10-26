package algorithms.sort;

import java.lang.reflect.Method;

public class SortTestHelper {

    private SortTestHelper() {
    }

    // 生成有 n 个元素的随机整型数组，每个元素的随机范围为 [rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        if (!(rangeL <= rangeR)) {
            throw new IllegalArgumentException("rangeL must be less then or equal to rangeR");
        }

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
            arr[i] = new Integer(r);
        }

        return arr;
    }

    // 打印 arr 数组的所有内容
    public static void printArray(Object[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 判断 arr 数组是否有序
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;

        return true;
    }

    // 测试 sortClassName 所对应的排序算法排序 arr 数组所得到结果的正确性和算法运行时间
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
            if (!isSorted(arr)) {
                throw new Exception(sortClass.getSimpleName() + " 排序失败");
            }

            System.out.println(sortClass.getSimpleName() + " : " + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
