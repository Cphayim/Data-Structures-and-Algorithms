package com.cphayim.ds.interfaces;

/**
 * @author Cphayim
 * @date Created in 2018/6/4 13:23
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
