package com.github.zhuo.algorithm.leetcode.problems.problems801_900.problems859;

/**
 * https://leetcode-cn.com/problems/buddy-strings/
 * 亲密字符串
 * 难度 简单
 *
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true；否则返回 false 。
 *
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 *
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 * 提示：
 *
 * 1 <= s.length, goal.length <= 2 * 10^4
 * s 和 goal 由小写英文字母组成
 *
 */
public class BuddyStrings {

    public static void main(String[] args) {
        BuddyStrings buddyStrings = new BuddyStrings();
        System.out.println(buddyStrings.budyStrings("ab", "ba"));
        System.out.println(buddyStrings.budyStrings("ab", "ab"));
    }

    /**
     * 1、如果长度不同或者词频不同 肯定不是亲密字符
     * 2、如果不同字符个数为2,
     */
    public boolean budyStrings(String s, String goal) {
        int length = s.length();
        int length1 = goal.length();
        if (length != length1) return false;
        int[] sChar = new int[26];
        int[] gChar = new int[26];
        int diff = 0;
        for (int i = 0; i < length; i++) {
            int i1 = s.charAt(i) - 'a';
            sChar[i1]++;
            int i2 = goal.charAt(i) - 'a';
            gChar[i2]++;
            if(i1 != i2) {
                diff ++;
            }
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if (sChar[i] != gChar[i]) return false;
            if (sChar[i] > 1) ok = true;
        }
        return diff == 2 || (diff == 0 && ok);
    }

}
