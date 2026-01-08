package com.github.zhuo.algorithm.leetcode.problems.problems201_300;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * 反转链表
 * 难度 简单
 *
 * 此类题型需反复练习
 */
public class Solution206 {

    public static void main(String[] args) {
        ListNode listNode = getListNode(new int[]{1,2,3,4,5});
        ListNode listNode1 = reverseList(listNode);
        System.out.println("------------------");
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    /**
     * 递归方式反转链表
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        ListNode(int val,  ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode getListNode(int[] len){
        ListNode head = null,tail = null;
        for (int i = 0; i < len.length; i++) {
            if (head == null){
                head = tail = new ListNode(len[i]);
            } else {
                tail.next = new ListNode(len[i]);
                tail = tail.next;
            }
        }
        return head;
    }

}
