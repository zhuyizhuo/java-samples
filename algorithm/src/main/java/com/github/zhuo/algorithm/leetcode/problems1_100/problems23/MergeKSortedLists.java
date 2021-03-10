package com.github.zhuo.algorithm.leetcode.problems1_100.problems23;

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
        //todo 可优化时间复杂度
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
