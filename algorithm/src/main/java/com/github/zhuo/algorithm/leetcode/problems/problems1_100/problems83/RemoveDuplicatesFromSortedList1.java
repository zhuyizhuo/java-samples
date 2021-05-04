package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems83;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * 删除排序链表中的重复元素
 * 难度 简单
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class RemoveDuplicatesFromSortedList1 {

    public static void main(String[] args) {
        ListNode listNode = getListNode(new int[]{1, 1, 1,2,2,3,4,5});
        ListNode listNode1 = deleteDuplicates(listNode);
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 34.31% 的用户
     * 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 93.17% 的用户
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode newHead = new ListNode(head.val);
        ListNode tail = newHead;
        while (head != null){
            while (head != null && head.val == tail.val){
                head = head.next;
            }
            tail.next = new ListNode(head.val);
            tail = tail.next;
        }
        return newHead;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
