package com.github.zhuo.algorithm.leetcode.problems.problems1401_1500;

/**
 * 将二进制表示减到 1 的步骤数
 *
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 *
 * 如果当前数字为偶数，则将其除以 2 。
 *
 * 如果当前数字为奇数，则将其加上 1 。
 *
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 */
public class Solution1404 {

    /**
     * beats 100%
     */
    public int numSteps(String s) {

        int steps = 0; // 记录总步数
        int carry = 0; // 记录进位（0=无进位，1=有进位）

        // 从右向左遍历，直到只剩首位（i > 0 意味着至少保留最左边的字符）
        for (int i = s.length() - 1; i > 0; i--) {
            char c = s.charAt(i);

            // 核心判断：当前位 + 进位 = 实际值
            // 如果实际值是1，说明是奇数
            if ((c - '0') + carry == 1) {
                // 奇数情况：
                // 步骤1: 加1（产生进位）
                // 步骤2: 除以2（删末尾）
                // 所以需要 +2 步
                steps += 2;
                carry = 1; // 加1操作产生了进位
            } else {
                // 偶数情况：
                // 只需要除以2（删末尾）
                // 所以需要 +1 步
                steps += 1;
                // carry 保持不变（为什么？看下面详解）
            }
        }

        // 处理完所有位后，只剩首位了
        // 如果 carry = 1，说明首位需要 +1，变成 2，再除以2，所以额外 +1 步
        // 如果 carry = 0，说明首位就是 1，已经结束了
        return steps + carry;
    }
}