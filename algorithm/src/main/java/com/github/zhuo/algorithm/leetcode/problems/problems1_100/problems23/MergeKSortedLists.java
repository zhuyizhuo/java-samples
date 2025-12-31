package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems23;

import com.github.zhuo.algorithm.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * 合并K个升序链表
 *
 * 难度 困难
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
    }

    /**
     * 最直接的解法
     *
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 36.86% 的用户
     * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 96.73% 的用户
     */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> all = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            while (list != null){
                all.add(list.val);
                list = list.next;
            }
        }
        if (all.size() == 0){
            return null;
        }
        Collections.sort(all);
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0; i < all.size(); i++) {
            tail.next = new ListNode();
            tail = tail.next;
            tail.val = all.get(i);
        }
        return head.next;
    }
}


/**
 * beats 100%
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedLists1 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        return mergeList(lists, 0, lists.length - 1);
    }

    public ListNode mergeList(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeListTwo(mergeList(lists, l, mid), mergeList(lists, mid+1, r));
    }

    public ListNode mergeListTwo(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = null != list1 ? list1 : list2;
        return head.next;

    }
}