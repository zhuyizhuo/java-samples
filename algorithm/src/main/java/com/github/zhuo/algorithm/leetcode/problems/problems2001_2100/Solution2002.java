package com.github.zhuo.algorithm.leetcode.problems.problems2001_2100;

/**
 * 两个回文子序列长度的最大乘积
 *
 * 给你一个字符串 s ，请你找到 s 中两个 不相交回文子序列 ，使得它们长度的 乘积最大 。两个子序列在原字符串中如果没有任何相同下标的字符，则它们是 不相交 的。
 *
 * 请你返回两个回文子序列长度可以达到的 最大乘积 。
 *
 * 子序列 指的是从原字符串中删除若干个字符（可以一个也不删除）后，剩余字符不改变顺序而得到的结果。如果一个字符串从前往后读和从后往前读一模一样，那么这个字符串是一个 回文字符串 。
 *
 *提示：
 *
 * 2 <= s.length <= 12
 * s 只含有小写英文字母。
 */
public class Solution2002 {
    /**
     * beats 100%
     */
    public int maxProduct(String s) {

        char [] cs = s.toCharArray();
        int n = cs.length;
        int [] dp =new int[1 << n];

        for(int i = 0; i < n;i++){
            int right = 1 << i;
            dp[right] = 1;

            for(int j = i - 1; j >= 0; j--){
                int left = 1 << j;
                for(int mask = 0; mask < 1 << (i - j - 1); mask++){

                    int mid = mask << (j + 1);
                    int nmask = left| mid|right;
                    if(cs[i] == cs[j])
                        dp[nmask] = dp[mid] + 2;
                    else
                        dp[nmask] = Math.max(dp[left|mid], dp[mid|right]);
                }
            }
        }

        int result = 0;
        int mask = (1 << n) - 1;

        for(int i = 0; i <= mask / 2;i++)
            result = Math.max(result, dp[i] * dp[i ^ mask]);

        return result;
    }
}
