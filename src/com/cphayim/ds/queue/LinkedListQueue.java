package com.cphayim.ds.queue;

import com.cphayim.ds.interfaces.Queue;

/**
 * @author Cphayim
 * @date Created in 2018/6/13 00:00
 */
public class LinkedListQueue<E> implements Queue<E> {

    /**
     * 链表节点类
     * 内部类
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 链表头节点和尾节点
    private Node head, tail;

    // 当前队列长度
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * 获取队列长度
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 元素入队
     * @param e
     */
    @Override
    public void enqueue(E e) {

        // tail 为 null（此时 head 也一定为 null）表示队列为空
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from empty queue.");

        Node retNode = head;
        head = head.next;
        retNode.next = null;

        // 如果此时队列为空，维护一下 tail
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {

        if (isEmpty())
            throw new IllegalArgumentException("Queue is Empty.");

        return head.e;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
