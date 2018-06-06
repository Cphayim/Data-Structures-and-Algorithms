package com.cphayim.ds;

import com.cphayim.ds.interfaces.Queue;

import java.util.Arrays;

/**
 * @author Cphayim
 * @date Created in 2018/6/6 23:49
 */
public class LoopQueue<E> implements Queue<E> {

    // 队列容器
    private E[] data;

    // 队首和队尾的索引
    // 当 front == tail 时，表示队列为空
    // 当 (tail + 1) % data.length == front 时，表示队列为满
    private int front, tail;

    // 队列当前长度
    private int size;

    public LoopQueue(int capacity) {

        // 循环队列中需要留空一个位置，所以使用用户传递的容量+1
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 获取队列的容积
     * 时间复杂度：O(1)
     * @return
     */
    public int getCapacity() {

        // 留空的1位对用户隐藏
        return data.length - 1;
    }

    /**
     * 判断队列是否为空
     * 时间复杂度：O(1)
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 判断当前队列的长度
     * 时间复杂度：O(1)
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 元素入队
     * 时间复杂度：O(1) 均摊
     * @param e
     */
    @Override
    public void enqueue(E e) {

        // 判断队列是否已满
        if ((tail + 1) % data.length == front) {
            // 扩容
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 元素出队
     * 时间复杂度：O(1) 均摊
     * @return
     */
    @Override
    public E dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        // 缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    /**
     * 获取队列的第一个元素
     * 时间复杂度：O(1)
     * @return
     */
    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            // 如果不是最后一个元素，补一个逗号
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }


    /**
     * 队列容量伸缩
     * 时间复杂度：O(n)
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        // 创建一个新的队列
        E[] newData = (E[]) new Object[newCapacity + 1];

        // 将原队列的元素转移到新队列中（考虑环的问题）
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }
}
