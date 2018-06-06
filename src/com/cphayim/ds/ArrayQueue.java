package com.cphayim.ds;

import com.cphayim.ds.interfaces.Queue;

/**
 * @author Cphayim
 * @date Created in 2018/6/6 23:10
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * 获取当前队列的长度
     * 时间复杂度：O(1)
     * @return
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * 判断当前队列是否为空
     * 时间复杂度：O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取当前队列的容量
     * 时间复杂度：O(1)
     * @return
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 元素入队
     * 时间复杂度：O(1) 均摊
     * @param e
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 元素出队
     * 时间复杂度：O(n)
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 获取队首元素
     * 时间复杂度：O(1)
     * @return
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            // 如果不是最后一个元素，补一个逗号
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail  ");
        return res.toString();
    }
}
