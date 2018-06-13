package com.cphayim.algo;

/**
 * @author Cphayim
 * @date Created in 2018/6/13 22:34
 */

import java.nio.file.LinkOption;

/**
 * leetcode <203>
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    // 链表节点的构造方法
    // 使用 arr 作为参数，创建一个链表，当前的 ListNode 为链表头的节点
    ListNode(int[] arr) {

        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr cannot be empty");

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点为头节点的链表信息字符串
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}

public class RemoveLinkedListElements {
    // 不使用虚拟头节点的解法
//    public ListNode removeElements(ListNode head, int val) {
//
//        // 如果头节点不为空，且头节点的值等于待删除的值，while 可以删除前面连续几个值为 val 的节点
//        while (head != null && head.val == val) {
//            ListNode delNode = head;
//            head = head.next;
//            delNode.next = null;
//        }
//
//        // 如果此时 head 为 null 说明链表已为空，直接返回
//        if (head == null)
//            return null;
//
//        // 此时 prev 不可能为 null
//        ListNode prev = head;
//        // 每次循环判断 prev.next 是否为 null
//        while (prev.next != null) {
//            if (prev.next.val == val) {
//                // 将 prev.next 指向删除的节点的 next 节点
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode = null;
//            } else {
//                // 将 prev 下移
//                prev = prev.next;
//            }
//        }
//
//        return head;
//    }

    // 使用虚拟头节点的解法
    public ListNode removeElements(ListNode head, int val) {

        // 创建虚拟头节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 由于虚拟头节点的存在，链表上每一个节点都有前一个节点，因此可以直接遍历整个链表
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode = null;
            } else {
                prev = prev.next;
            }
        }

        // 此时 head 的引用可能是一个被删除的节点，因此返回 dummyHead.next
        return dummyHead.next;
    }

    public static void main(String[] args) {

        RemoveLinkedListElements rlle = new RemoveLinkedListElements();
        int[] nums = {3, 3, 3, 6, 4, 5, 3, 6};

        ListNode head1 = new ListNode(nums);
        System.out.println(head1);
        ListNode res1 = rlle.removeElements(head1, 6);
        System.out.println(res1);

        ListNode head2 = new ListNode(nums);
        System.out.println(head2);
        ListNode res2 = rlle.removeElements(head2, 3);
        System.out.println(res2);
    }
}

