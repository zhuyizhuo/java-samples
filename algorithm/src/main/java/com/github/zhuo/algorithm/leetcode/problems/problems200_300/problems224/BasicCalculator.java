package com.github.zhuo.algorithm.leetcode.problems.problems200_300.problems224;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/basic-calculator/
 * 基本计算器
 * 难度 困难
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 *
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 *
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 *
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 10^5
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 *
 */
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("2147483647"));
        System.out.println(calculate("1-11"));
    }

    /**
     * 思路
     *  使用栈  当遇到右括号时 ，依次弹出栈内元素 ，直到栈顶元素为左括号， 计算结果并重新入栈。
     *  当字符串遍历完成，栈内仍有元素，依次计算剩余元素即可。
     *
     * 注意点：数字不止一位。
     *
     * 执行用时： 28 ms , 在所有 Java 提交中击败了 22.07% 的用户
     * 内存消耗： 44.9 MB , 在所有 Java 提交中击败了 11.83% 的用户
     */
    public static int calculate(String s) {
        Deque<String> stack = new LinkedList();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == ')'){
                Deque<String> calcStack = new LinkedList();
                while (!stack.isEmpty() && !"(".equals(stack.peekFirst())){
                    calcStack.push(stack.pop());
                }
                //删除左括号
                if (!stack.isEmpty() && "(".equals(stack.peekFirst())){
                    stack.removeFirst();
                }
                int total = 0;
                while (!calcStack.isEmpty()){
                    String pop = calcStack.pop();
                    switch (pop){
                        case "+":
                            total += getPopCurrent(calcStack);
                            break;
                        case "-":

                            total -= getPopCurrent(calcStack);
                            break;
                        default:
                            total = total * 10 + Integer.parseInt(pop);
                    }
                }
                stack.push(String.valueOf(total));
            } else {
                stack.push(String.valueOf(c));
            }
        }
        int total = 0;
        while (!stack.isEmpty()){
            String last = stack.pollLast();
            switch (last){
                case "+":
                    total += getLastCurrent(stack);
                    break;
                case "-":
                    total -= getLastCurrent(stack);
                    break;
                default:
                    total = total * 10 + Integer.parseInt(last);
            }
        }
        return total;
    }

    private static int getPopCurrent(Deque<String> calcStack) {
        int current = 0;
        while (!calcStack.isEmpty() && !"+".equals(calcStack.peekFirst()) && !"-".equals(calcStack.peekFirst())){
            current = current * 10 + Integer.parseInt(calcStack.pop());
        }
        return current;
    }

    private static int getLastCurrent(Deque<String> calcStack) {
        int current = 0;
        while (!calcStack.isEmpty() && !"+".equals(calcStack.peekLast()) && !"-".equals(calcStack.peekLast())){
            current = current * 10 + Integer.parseInt(calcStack.pollLast());
        }
        return current;
    }

}
