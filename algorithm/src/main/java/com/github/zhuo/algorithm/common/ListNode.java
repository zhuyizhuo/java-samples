package com.github.zhuo.algorithm.common;

/**
 * 链表
 */
public class ListNode {
    public static int val;
    public static ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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
