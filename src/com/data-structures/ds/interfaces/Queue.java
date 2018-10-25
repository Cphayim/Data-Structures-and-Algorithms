package com.cphayim.ds.interfaces;

/**
 * @author Cphayim
 * @date Created in 2018/6/6 23:07
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
