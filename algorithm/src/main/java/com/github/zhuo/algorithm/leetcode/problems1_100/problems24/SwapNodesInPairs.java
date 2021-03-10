package com.github.zhuo.algorithm.leetcode.problems1_100.problems24;

/***
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * 两两交换链表中的节点
 */
public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode listNode = getListNode(new int[]{1, 2, 3, 4});
        ListNode x = swapPairs(listNode);
        while (x != null){
            System.out.println(x.val);
            x = x.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = null;
        ListNode tail = null;
        ListNode pre = null;
        int step = 0;
        while (head != null){
            step ++;
            if (step == 2){
                if (newHead == null){
                    newHead = tail = new ListNode(head.val);
                } else {
                    tail.next = new ListNode(head.val);
                    tail = tail.next;
                }
                tail.next = pre;
                tail = tail.next;
                step = 0;
            } else if (step == 1){
                pre = new ListNode(head.val);
            }
            head = head.next;
            if (step == 1 && head == null){
                tail.next = pre;
            }
        }
        return newHead;
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
