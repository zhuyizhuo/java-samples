package com.github.zhuo.algorithm.common;

public class ListNodeUtil {

    public static void main(String[] args) {
        Integer[] s = {1,2,3,4,5};
        ListNode node = createListNode(s);
        System.out.println("构造成功");
    }

    /**
     * 单链表构造
     */
    public static ListNode createListNode(Integer[] s) {
        ListNode head = new ListNode();
        ListNode tail = head;
        for (int i = 0; i < s.length; i++) {
            tail.val = s[i];
            if (i != s.length - 1){
                tail.next = new ListNode();
                tail = tail.next;
            }
        }
        return head;
    }
}
