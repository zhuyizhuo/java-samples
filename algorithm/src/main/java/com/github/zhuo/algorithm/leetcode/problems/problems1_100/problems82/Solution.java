package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems82;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 删除排序链表中的重复元素 II
 * 难度 中等
 *
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
 * 只保留原始链表中没有重复出现的数字。
 *
 * 返回同样按升序排列的结果链表。
 *
 * 提示：
 *
 *  链表中节点数目在范围 [0, 300] 内
 *  -100 <= Node.val <= 100
 *  题目数据保证链表已经按升序排列
 */
public class Solution {

    public static void main(String[] args) {
//        ListNode listNode = getListNode(new int[]{1,1,1,2,3});
//        ListNode listNode = getListNode(new int[]{1,2,2});
//        ListNode listNode = getListNode(new int[]{1,1,1,2,3,3,4,5,6,6,7});
//        ListNode listNode = getListNode(new int[]{1});
        ListNode listNode = getListNode(new int[]{1,1,1});
//        ListNode listNode = new ListNode();
        ListNode x = deleteDuplicates(listNode);
        while (x != null){
            System.out.println(x.val);
            x = x.next;
        }
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

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 64.24% 的用户
     * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 80.53% 的用户
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        int sameVal = -200;
        ListNode newHead = new ListNode();
        newHead.val = -200;
        newHead.next = head;
        ListNode tail = newHead;
        while (tail.next != null && tail.next.next != null){
            if (tail.next.val == tail.next.next.val || tail.next.val == sameVal) {
                sameVal = tail.next.val;
                tail.next = tail.next.next;
            } else {
                tail = tail.next;
            }
        }
        if (tail.next.val == sameVal){
            tail.next = null;
        }
        return newHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
