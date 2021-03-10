package com.github.zhuo.algorithm.leetcode.problems1_100.problems83;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * 删除排序链表中的重复元素
 */
public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        ListNode listNode = getListNode(new int[]{1, 1, 1,2,2,3,4,5});
        ListNode listNode1 = deleteDuplicates(listNode);
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        Map m = new HashMap<>();
        m.put(head.val, head.val);
        ListNode newHead = new ListNode(head.val);
        ListNode tail = newHead;
        while (head.next != null){
            int val = head.next.val;
            if (m.get(val) == null){
                m.put(val, val);
                tail.next = new ListNode(val);
                tail = tail.next;
            }
            head = head.next;
            if (head == null){
                break;
            }
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
