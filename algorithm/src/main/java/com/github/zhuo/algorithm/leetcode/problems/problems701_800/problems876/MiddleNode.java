package com.github.zhuo.algorithm.leetcode.problems.problems701_800.problems876;

import com.github.zhuo.algorithm.common.ListNode;
import com.github.zhuo.algorithm.common.ListNodeUtil;

/**
 * 链表的中间结点
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 * 难度 简单
 *
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class MiddleNode {

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.createListNode(new int[]{1, 2, 3, 4, 5});
//        ListNode listNode = ListNodeUtil.createListNode(new int[]{1,2,3,4,5,6});
//        ListNode listNode = ListNodeUtil.createListNode(new int[]{1});
//        ListNode listNode = ListNodeUtil.createListNode(new int[]{1, 2});
//        ListNode listNode = ListNodeUtil.createListNode(new int[]{1, 2, 3});
        ListNode listNode1 = middleNode(listNode);
        System.out.println("完成");
        while (listNode1 != null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.7 MB , 在所有 Java 提交中击败了 96.65% 的用户
     * 通过测试用例： 36 / 36
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            if (slow == null){
                slow = head;
            } else {
                slow = slow.next;
            }
            fast = fast.next.next;
        }
        if (slow == null){
            return head;
        }
        return slow.next;
    }
}
