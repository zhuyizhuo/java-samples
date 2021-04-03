package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems20;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * 有效的括号
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    /**
     * 思路：审题，可联系到栈的结构，遇到括号左半部分入栈，
     * 遇到括号右半部分 将栈顶元素取出并比对 如果是有效括号 则移除栈顶元素
     * 最终判断栈里是否还有元素 如果没有元素说明全部匹配 如果还存在元素 说明未全部匹配
     * @param s 输入字符串
     * @return 是否都是有效的闭合括号
     */
    public static boolean isValid(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        if (s.length() < 2){
            return false;
        }
        for (int i = 0, len = s.length(); i < len; i++) {
            char current = s.charAt(i);
            if(current == '(' || current == '[' || current == '{'){
                linkedList.push(current);
            } else {
                if (linkedList.isEmpty()){
                    return false;
                }
                char prev = linkedList.getFirst().charValue();
                if(current == ')' && prev == '(' || current == ']' && prev == '[' || current == '}' && prev == '{'){
                    linkedList.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return linkedList.size() == 0;
    }
}
