package com.github.zhuo.algorithm.leetcode.problems21;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 合并两个有序链表
 * 难度 简单
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode left = getListNode(new int[]{1,2,4});
        ListNode right = getListNode(new int[]{1,3,4});
        ListNode listNode = mergeTwoLists(left, right);
        while (listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 合并两个有序链表
     * 思路: 判断两个链表的值，如果头结点为空，同时设置头尾节点为较小的链表，并且将较小链表指向当前链表的下一节点。
     * 如果头节点不为空，则将尾节点的下一个节点设置为较小的链表，并且将较小链表指向当前链表的下一节点，同时将尾结点指向尾节点的下一个节点。
     * 直至有一个链表元素全部循环完毕，将尾结点的下一个节点设置为另一个链表，并结束循环。
     *
     * 执行用时 0ms 超过 100% 的用户
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode head = null;
        ListNode tail = null;
        while (true){
            if (head == null){
                if (l1.val <= l2.val){
                    head = tail = l1;
                    l1 = l1.next;
                } else {
                    head = tail = l2;
                    l2 = l2.next;
                }
            } else {
                if (l1.val <= l2.val){
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }
                tail = tail.next;
            }
            if (l1 == null){
                tail.next = l2;
                break;
            }
            if (l2 == null){
                tail.next = l1;
                break;
            }
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
