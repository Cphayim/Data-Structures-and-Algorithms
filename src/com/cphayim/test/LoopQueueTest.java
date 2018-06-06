package com.cphayim.test;

import com.cphayim.ds.LoopQueue;

/**
 * @author Cphayim
 * @date Created in 2018/6/7 00:35
 */
public class LoopQueueTest {
    public static void main(String[] args) {
        LoopQueue<Integer> quque = new LoopQueue<>();

        for (int i = 0; i < 20; i++) {
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
