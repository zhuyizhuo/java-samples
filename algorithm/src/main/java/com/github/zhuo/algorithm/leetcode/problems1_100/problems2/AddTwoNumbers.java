package com.github.zhuo.algorithm.leetcode.problems1_100.problems2;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * 两数相加
 *
 * 难度 中等
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode head = getListNode(new int[]{2,4,3});
        ListNode head1 = getListNode(new int[]{5,6,4});

        ListNode listNode = addTwoNumbers(head, head1);

        while (listNode != null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 思路 TODO
     *
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100% 的用户
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (true){
            int sum = carry;
            if (l1 != null){
               sum += l1.val;
            }
            if (l2 != null){
                sum += l2.val;
            }
            if (l1 == null && l2 == null){
                if (carry == 1){
                   if (head == null){
                       head = tail = new ListNode(sum);
                   } else {
                       tail.next = new ListNode(sum);
                       tail = tail.next;
                   }
                }
                break;
            }
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
            if (sum > 9){
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (head == null){
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
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