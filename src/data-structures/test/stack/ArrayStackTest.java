package com.cphayim.test.stack;

import com.cphayim.ds.stack.ArrayStack;

/**
 * @author Cphayim
 * @date Created in 2018/6/4 13:48
 */
public class ArrayStackTest {
    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack<>();

        // 入栈测试
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        // 出栈测试
        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        // 获取栈顶元素测试
        System.out.println(stack.peek());

        // 获取当前栈大小
        System.out.println(stack.getSize());
    }
}
