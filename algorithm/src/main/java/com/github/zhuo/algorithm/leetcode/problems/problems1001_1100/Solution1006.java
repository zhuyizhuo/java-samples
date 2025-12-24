package com.github.zhuo.algorithm.leetcode.problems.problems1001_1100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/clumsy-factorial/
 * 笨阶乘
 * 难度 中等
 * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
 *
 * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
 *
 * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：
 * 我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
 *
 * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
 *
 * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
 *
 */
public class Solution1006 {

    public static void main(String[] args) {
//        System.out.println(clumsy(4));
//        System.out.println(clumsy(10));
//        System.out.println(clumsy(10000));
        for (int i = 1; i < 10001; i++) {
            int tmp = clumsy(i);
            System.out.println(i + " : " + tmp + " - " + (tmp - i));
        }
    }

    /**
     * 执行用时： 14 ms , 在所有 Java 提交中击败了 8.39% 的用户
     * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 8.38% 的用户
     */
    public static int clumsy(int N) {
        Character[] signs = new Character[]{'*', '/', '+', '-'};
        Deque<Integer> deque = new LinkedList();
        deque.offerFirst(N);
        int index = 0;
        for (int i = N-1; i > 0; i--) {
            Character sign = signs[index%4];
            switch (sign){
                case '*':
                    deque.offerFirst(deque.pop() * i);
                    break;
                case '/':
                    deque.offerFirst(deque.pop() / i);
                    break;
                case '+':
                    deque.offerFirst(i);
                    break;
                case '-':
                    deque.offerFirst(i);
                    break;
                default:;
            }
            index++;
        }
        int result = 0;
        if (!deque.isEmpty()){
            result = deque.pollLast();
        }
        boolean plus = true;
        while (deque.size() > 0){
            if (plus){
                result += deque.pollLast();
                plus = false;
            } else {
                result -= deque.pollLast();
                plus = true;
            }
        }
        return result;
    }


    /**
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 14.84% 的用户
     * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 12.26% 的用户
     */
    public static int clumsy1(int N) {
        Deque<Integer> deque = new LinkedList();
        deque.offerFirst(N);
        N--;
        int index = 0;
        while (N > 0){
            if (index % 4 == 0){
                deque.push(deque.pop() * N);
            } else if (index % 4 == 1){
                deque.push(deque.pop() / N);
            } else if (index % 4 == 2){
                deque.push(N);
            } else if (index % 4 == 3){
                deque.push(-N);
            }
            index++;
            N--;
        }
        int result = 0;
        while (!deque.isEmpty()){
            result += deque.pop();
        }
        return result;
    }

}

class Solution {

    /**
     * 公式推导法 总结规律
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 64.52% 的用户
     */
    public int clumsy(int N) {
        if (N == 1){
            return 1;
        } else if (N == 2){
            return 2;
        } else if (N == 3){
            return 6;
        } else if (N == 4){
            return 7;
        }
        if (N % 4 == 0){
            return N + 1;
        } else if (N % 4 <= 2){
            return N + 2;
        } else {
            return N - 1;
        }
    }
}