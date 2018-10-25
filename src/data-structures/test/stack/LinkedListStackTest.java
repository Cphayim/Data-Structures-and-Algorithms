package com.cphayim.test.stack;

import com.cphayim.ds.stack.LinkedListStack;

/**
 * @author Cphayim
 * @date Created in 2018/6/11 13:21
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

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
