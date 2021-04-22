package com.github.zhuo.algorithm.leetcode.problems.problems301_400.problems395;

/**
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * 至少有K个重复字符的最长子串
 * 难度 中等
 *
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 */
public class LongestSubstring {

    public static void main(String[] args) {

    }

    /**
     * 对于字符串 ss，如果存在某个字符  ch，它的出现次数大于 0 且小于 k，
     * 则任何包含 ch 的子串都不可能满足要求。也就是说，我们将字符串按照 ch 切分成若干段，
     * 则满足要求的最长子串一定出现在某个被切分的段内，而不能跨越一个或多个段。
     * 因此，可以考虑分治的方式求解本题。
     *
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 78.51% 的用户
     * 内存消耗： 36.2 MB , 在所有 Java 提交中击败了 93.78% 的用户
     */
    public int longestSubstring(String s, int k) {
        int length = s.length();
        return dfs(s, 0, length - 1, k);
    }

    private int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }

}
