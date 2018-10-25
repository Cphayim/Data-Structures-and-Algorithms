package com.cphayim.test.queue;

import com.cphayim.ds.queue.ArrayQueue;

/**
 * @author Cphayim
 * @date Created in 2018/6/6 23:23
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> quque = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            // 入队
            quque.enqueue(i);
            System.out.println(quque);

            if (i % 3 == 2) {
                // 出队
                quque.dequeue();
                System.out.println(quque);
            }
        }

        // 获取当前队首元素
        System.out.println(quque.getFront());

        // 获取当前队列长度
        System.out.println(quque.getSize());
    }
}
