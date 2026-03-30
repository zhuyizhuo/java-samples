package com.github.zhuo.algorithm.leetcode.problems.problems2801_2900;

/**
 * 判断通过操作能否让字符串相等 II
 *
 * 给你两个字符串 s1 和 s2 ，两个字符串长度都为 n ，且只包含 小写 英文字母。
 *
 * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
 *
 * 选择两个下标 i 和 j ，满足 i < j 且 j - i 是 偶数，然后 交换 这个字符串中两个下标对应的字符。
 *
 *
 * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
 */
public class Solution2840 {

    /**
     * beats 98.68%
     */
    public boolean checkStrings(String s1, String s2) {
        //奇数位和偶数位的字母出现的次数
        //分别统计奇数和偶数位字母出现的次数，看次数是否相同
        int[][] cnts = new int[2][26];
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for(int i=0;i<chars1.length;i++){
            cnts[i&1][chars1[i]-'a']++;
            cnts[i&1][chars2[i]-'a']--;
        }
        for(int j=0;j<26;j++){
            if(cnts[0][j]!=0 || cnts[1][j]!=0){
                return false;
            }
        }
        return true;
    }
}