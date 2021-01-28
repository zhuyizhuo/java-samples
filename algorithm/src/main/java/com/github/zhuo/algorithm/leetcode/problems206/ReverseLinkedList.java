package com.github.zhuo.algorithm.leetcode.problems206;

import com.github.zhuo.algorithm.common.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = ListNode.getListNode(new int[]{1,2,3,4,5});
        ListNode listNode1 = reverseList(listNode);
        while (listNode1 != null){
            System.out.println(listNode1.getVal());
            listNode1 = listNode1.getNext();
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return new ListNode();
        }
        ListNode listNode = reverseList(head.getNext());
        listNode.setNext(new ListNode(head.getVal()));
        return listNode;
    }

}
