package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems19;

import com.github.zhuo.algorithm.common.ListNode;
import com.github.zhuo.algorithm.common.ListNodeUtil;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * 删除链表的倒数第 N 个结点
 *
 * 难度 中等
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 提示：
 *
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNodeFromEndOfList1 {

    public static void main(String[] args) {
        // 输入 1,2,3   2 输出 1,3
        ListNode listNode = ListNodeUtil.createListNode(new int[]{1,2,3});
        // 输入 1,2   2  输出 2
//        ListNode listNode = ListNodeUtil.createListNode(new int[]{1,2});
        ListNode x = removeNthFromEnd(listNode, 2);
        while (x != null){
            System.out.println(x.val);
            x = x.next;
        }
    }

    /**
     * 双指针算法 但不是最优解 额外处理了边界值  可通过添加一个头节点的方式解决边界问题
     *
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 51.62% 的用户
     * 通过测试用例： 208 / 208
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            return null;
        }
        ListNode fastTail = head;
        int tmp = n;
        while (fastTail != null && tmp > 0){
            fastTail = fastTail.next;
            tmp--;
        }
        if(fastTail == null){
            head = head.next;
            return head;
        }
        fastTail = fastTail.next;
        ListNode slowTail = head;
        while (fastTail != null){
            fastTail = fastTail.next;
            slowTail = slowTail.next;
        }
        if (slowTail.next != null){
            slowTail.next = slowTail.next.next;
        }
        return head;
    }
}
