package com.github.zhuo.algorithm.leetcode.problems.problems1201_1300.problems1208;

/**
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 *
 * 尽可能使字符串相等
 * 
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 */
public class GetEqualSubstringsWithinBudget {

    public static void main(String[] args) {
        //TODO 和 424 题相似

    }

    /**
     * 两字符串同下标相等的最长连续子串 包含转换后的字符
     *
     * 挨个下标比对字符 如果不相等 则用 开销 减去 字符的差的绝对值
     * 如果绝对值小于0 记录最长连续数 如果未比对完毕
     *
     */
    public int equalSubstring(String s, String t, int maxCost) {

        return 0;
    }
}
