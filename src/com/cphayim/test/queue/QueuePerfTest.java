package com.cphayim.test.queue;

import com.cphayim.ds.queue.ArrayQueue;
import com.cphayim.ds.queue.LoopQueue;
import com.cphayim.ds.interfaces.Queue;

import java.util.Random;

/**
 * @author Cphayim
 * @date Created in 2018/6/7 15:28
 */

/**
 * 队列性能测试
 */
public class QueuePerfTest {

    /**
     * 测试使用 q 执行 opCount 个 enqueue 和 dequeue 操作所需的时间，单位：秒
     * @param q
     * @param opCount
     * @return
     */
    private static double testQueue(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();

        for (int i = 0; i < opCount; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < opCount; i++)
            q.dequeue();

        long endTime = System.nanoTime();

        return (endTime - startTime) / (double) 1e9;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + "s");
    }
}
