package com.github.zhuo.algorithm.leetcode.problems1_100.problems19;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * 删除链表的倒数第 N 个结点
 */
public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
        ListNode listNode = getListNode(new int[]{1,2,3});
        System.out.println(r.removeNthFromEnd(listNode, 2));
    }

    /**
     * 需考虑各种边界值
     * 链表长度只有1  节点为1
     * 链表长度为2  节点为2 刚好是链表首节点
     * 链表长度为2  节点为1 刚好是链表结束节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tail = head;
        ListNode nthNode = head;
        int step = 0;
        while (tail.next != null){
            if (step >= n){
                nthNode = nthNode.next;
            }
            tail = tail.next;
            step ++;
        }
        if (step == n - 1){
            head = head.next;
            return head;
        }
        if (step < n){
            return null;
        }
        if (step == 1){
            head.next = null;
            return head;
        }
        if (nthNode.next != null){
            nthNode.next = nthNode.next.next;
        }
        return head;
    }

    private static ListNode getListNode(int[] len) {
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
    
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
