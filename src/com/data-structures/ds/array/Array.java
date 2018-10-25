package com.cphayim.ds.array;

/**
 * @author Cphayim
 * @date Created in 2018/6/3 19:03
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量 capacity 构造 array
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认数组的容量 capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * 时间复杂度：O(1)
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     * 时间复杂度：O(1)
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 返回数组是否为空
     * 时间复杂度：O(1)
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组末尾添加一个元素 e
     * 时间复杂度：O(1) 均摊
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 向数组开头添加一个元素 e
     * 时间复杂度：O(n)
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在数组索引为 index 的位置插入元素 e
     * 前置：当数组的 size 等于 capacity 时，将数组扩容1倍
     * 时间复杂度：O(n)
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        // 若 index 不在合法区间内，抛出一个异常
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Required index >= 0 and index <= size.");

        // 如果此时数组内的元素个数达到容量上限，进行数组扩容
        if (size == getCapacity())
            resize(2 * data.length);

        // 将数组中从 index 开始的元素后移一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 获取数组中 index 位置的元素
     * 时间复杂度：O(1)
     * @param index
     *
     * @return
     */
    public E get(int index) {

        // 若 index 不在合法区间内，抛出一个异常
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    /**
     * 获取数组中第一个元素
     * 时间复杂度：O(1)
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取数组中最后一个元素
     * 时间复杂度：O(1)
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }


    /**
     * 设置数组中 index 位置的元素
     * 时间复杂度：O(1)
     * @param index
     * @param e
     */
    public void set(int index, E e) {

        // 若 index 不在合法区间内，抛出一个异常
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }


    /**
     * 查找数组中是否有元素 e
     * 时间复杂度：O(n)
     * @param e
     *
     * @return
     */
    public boolean contains(E e) {
        return find(e) != -1;
    }

    /**
     * 查找数组中元素 e 的索引，如果不存在元素 e，则返回 -1
     * 时间复杂度：O(n)
     * @param e
     *
     * @return
     */
    public int find(E e) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    /**
     * 删除数组中指定索引的元素，返回删除的元素
     * 后置：当数组的 size 是 capacity 的 1/4 时，缩容为 1/2
     * 时间复杂度：O(n)
     * @param index
     */
    public E remove(int index) {

        // 若 index 不在合法区间内，抛出一个异常
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        // 将要删除的元素先保存起来
        E ret = data[index];
        // 将删除的元素所在位置后的元素前移一位
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak

        // 数组缩容
        if (size <= data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);

        return ret;
    }

    /**
     * 删除数组中的第一个元素，并返回删除的元素
     * 时间复杂度：O(n)
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除数组中的最后一个元素，并返回删除的元素
     * 时间复杂度：O(1) 均摊
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除元素 e
     * 时间复杂度：O(n)
     * @param e
     */
    public boolean removeElement(E e) {

        int index = find(e);
        if (index == -1) return false;

        remove(index);
        return true;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("array: size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            // 如果不是最后一个元素，补一个逗号
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    /**
     * 数组容量伸缩
     * 时间复杂度：O(n)
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];
        // 将原先 data 中的数据转移到 newData 中
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
