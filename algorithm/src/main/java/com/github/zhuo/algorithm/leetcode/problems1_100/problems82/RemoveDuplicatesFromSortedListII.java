package com.github.zhuo.algorithm.leetcode.problems1_100.problems82;

import java.util.ArrayList;
import java.util.List;

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
public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
//        ListNode listNode = getListNode(new int[]{1,1,1,2,3});
        ListNode listNode = getListNode(new int[]{1,1,1,2,3,3,4,5,6,6,7});
//        ListNode listNode = getListNode(new int[]{1});
//        ListNode listNode = getListNode(new int[]{1,1,1});
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
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 7.11% 的用户
     * 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 44.82% 的用户
     */
    public static ListNode deleteDuplicates(ListNode head) {
        int last = -200;
        ListNode newHead = null;
        ListNode tail = null;
        List<Integer> blackList = new ArrayList<>();
        while (head != null){
            if (head.val != last){
                if (!blackList.contains(last) && last != -200){
                    if (newHead == null){
                        newHead = tail = new ListNode(last);
                    } else {
                        tail.next = new ListNode(last);
                        tail = tail.next;
                    }
                }
            } else {
                blackList.add(last);
            }
            last = head.val;
            head = head.next;
        }
        if (tail != null){
            if (tail.val != last && !blackList.contains(last)) {
                tail.next = new ListNode(last);
            }
        } else {
            if (!blackList.contains(last) && last != -200){
                newHead = new ListNode(last);
            }
        }
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
