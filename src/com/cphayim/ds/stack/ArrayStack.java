package com.cphayim.ds.stack;

import com.cphayim.ds.array.Array;
import com.cphayim.ds.interfaces.Stack;

/**
 * @author Cphayim
 * @date Created in 2018/6/4 13:24
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    /**
     * 获取当前栈的大小
     * 时间复杂度：O(1)
     *
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断当前栈是否为空
     * 时间复杂度：O(1)
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取当前栈的容积
     * 时间复杂度：O(1)
     *
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 元素入栈
     * 时间复杂度：O(1) 均摊
     *
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 元素出栈，并返回
     * 时间复杂度：O(1) 均摊
     *
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 返回当前栈顶的元素
     * 时间复杂度：O(1)
     *
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            // 如果不是最后一个元素，补一个逗号
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
