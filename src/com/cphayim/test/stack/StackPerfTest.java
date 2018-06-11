package com.cphayim.test.stack;

/**
 * @author Cphayim
 * @date Created in 2018/6/11 13:24
 */

import com.cphayim.ds.interfaces.Stack;
import com.cphayim.ds.stack.ArrayStack;
import com.cphayim.ds.stack.LinkedListStack;

import java.util.Random;

/**
 * 栈性能测试
 */
public class StackPerfTest {
    /**
     * 测试用 s 执行 opCount 次 push 和 pop 操作所需的时间，单位：秒
     * @param s
     * @param opCount
     * @return
     */
    private static double testStack(Stack<Integer> s, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++)
            s.push(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < opCount; i++)
            s.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1e9;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        double time1 = testStack(arrayStack, opCount);
        System.out.println("ArrayStack, time: " + time1 + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        double time2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedListStack, time: "+ time2 + "s");
    }
}
