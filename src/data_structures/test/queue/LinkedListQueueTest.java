package com.cphayim.test.queue;

import com.cphayim.ds.queue.LinkedListQueue;

/**
 * @author Cphayim
 * @date Created in 2018/6/13 00:20
 */
public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<Integer> quque = new LinkedListQueue<>();

        for (int i = 0; i < 30; i++) {
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
