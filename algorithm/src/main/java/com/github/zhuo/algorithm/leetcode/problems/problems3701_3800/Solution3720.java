package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

/**
 * 大于目标字符串的最小字典序排列
 */
public class Solution3720 {
    /**
     * beats 91.94%
     */
    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        boolean b = dfs(0, target, chars, cnt, true);
        if (b) {
            return new String(chars);
        }
        return "";
    }

    private boolean dfs(int i, String target, char[] chars, int[] cnt, boolean isLimit) {
        if (i == target.length()) {
            if (new String(chars).compareTo(target) > 0) {
                return true;
            }
            return false;
        }
        for (char c = isLimit ? target.charAt(i) : 'a'; c <= 'z'; c++) {
            if (cnt[c - 'a'] > 0) {
                cnt[c - 'a']--;
                chars[i] = c;
                boolean b = dfs(i + 1, target, chars, cnt, isLimit && c == target.charAt(i));
                if (b) {
                    return b;
                }
                cnt[c - 'a']++;
            }
        }
        return false;
    }
}