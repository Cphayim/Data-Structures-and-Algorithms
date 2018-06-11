package com.cphayim.ds.linked_list;

/**
 * @author Cphayim
 * @date Created in 2018/6/7 16:48
 */
public class LinkedList<E> {

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

    // 虚拟头节点
    private Node dummyHead;
    // 链表中的元素个数
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中的元素个数
     * 时间复杂度：O(1)
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为0
     * 时间复杂度：O(1)
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的 index(0-based) 位置添加新的元素 e
     * 在链表中不是一个常用的操作，练习用：）
     * 关键：找到要添加的节点的前一个节点
     * 时间复杂度：O(n)
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        // 从虚拟头节点开始
        Node prev = dummyHead;

        // 找到要添加的节点的前一个节点（引入了 dummyHead，在链表头多出了一个节点，循环条件中的 index 不需要 -1）
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;

    }

    /**
     * 向链表头添加元素
     * 时间复杂度：O(1)
     * @param e
     */
    public void addFirst(E e) {
        this.add(0, e);
    }

    /**
     * 向链表尾部添加一个元素
     * 时间复杂度：O(n)
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的 index(0-based) 位置的元素
     * 在链表中不是一个常用的操作，练习用：）
     * 时间复杂度：O(n)
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        // 从虚拟头节点的下一个节点开始
        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     * 时间复杂度：O(1)
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     * 时间复杂度：O(n)
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 设置链表的 index(0-based) 位置的元素
     * 在链表中不是一个常用的操作，练习用：）
     * 时间复杂度：O(n)
     * @param index
     * @param e
     * @return
     */
    public void set(int index, E e) {

        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    /**
     * 查找链表中是否有元素 e
     * 时间复杂度：O(n)
     * @param e
     * @return
     */
    public boolean contains(E e) {

        Node cur = dummyHead.next;

        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    /**
     * 删除链表的 index(0-based) 位置的元素
     * 在链表中不是一个常用的操作，练习用：）
     * 时间复杂度：O(n)
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;

        return delNode.e;
    }

    /**
     * 删除链表的第一个元素
     * 时间复杂度：O(1)
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除链表的最后一个元素
     * 时间复杂度：O(n)
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");

        return res.toString();
    }
}
