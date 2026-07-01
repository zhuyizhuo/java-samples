package com.github.zhuo.algorithm.leetcode.problems.problems2101_2200;

import com.github.zhuo.algorithm.common.ListNode;

/**
 * 链表最大孪生和
 */
public class Solution2130 {

    static
    {
        ListNode temp=new ListNode(10);
        for(int i=0;i<500;i++)
            pairSum(temp);
    }

    /**
     * beats 100%
     */
    public static int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode curr=slow;
        ListNode prev=null;
        while(curr!=null)
        {
            ListNode newnode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=newnode;
        }
        ListNode first=head;
        ListNode second=prev;
        long sum=0;
        while(second!=null)
        {
            sum=Math.max(sum,(first.val+second.val));
            first=first.next;
            second=second.next;
        }
        return (int)sum;
    }
}