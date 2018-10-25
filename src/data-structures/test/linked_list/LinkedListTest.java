package com.cphayim.test.linked_list;

import com.cphayim.ds.linked_list.LinkedList;

/**
 * @author Cphayim
 * @date Created in 2018/6/11 00:29
 */
public class LinkedListTest {
    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        for(int i = 0; i < 5; i++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.addFirst(123);
        System.out.println(linkedList);

        linkedList.addLast(123);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
