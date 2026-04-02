package com.github.zhuo.algorithm.leetcode.problems.problems3401_3500;

/**
 * 字典序最小的生成字符串
 * hard
 *
 * 给你两个字符串，str1 和 str2，其长度分别为 n 和 m 。
 *
 * 如果一个长度为 n + m - 1 的字符串 word 的每个下标 0 <= i <= n - 1 都满足以下条件，则称其由 str1 和 str2 生成：
 *
 * 如果 str1[i] == 'T'，则长度为 m 的 子字符串（从下标 i 开始）与 str2 相等，即 word[i..(i + m - 1)] == str2。
 * 如果 str1[i] == 'F'，则长度为 m 的 子字符串（从下标 i 开始）与 str2 不相等，即 word[i..(i + m - 1)] != str2。
 * 返回可以由 str1 和 str2 生成 的 字典序最小 的字符串。如果不存在满足条件的字符串，返回空字符串 ""。
 *
 * 如果字符串 a 在第一个不同字符的位置上比字符串 b 的对应字符在字母表中更靠前，则称字符串 a 的 字典序 小于 字符串 b。
 * 如果前 min(a.length, b.length) 个字符都相同，则较短的字符串字典序更小。
 *
 * 子字符串 是字符串中的一个连续、非空 的字符序列。
 */
public class Solution3474 {

    /**
     * beats 91.67%
     */
    public String generateString(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        char[] s = new char[n + m - 1];
        char[] s2 = str2.toCharArray(), s1 = str1.toCharArray();
        for (int i = 0; i < n; i++) {
            if (s1[i] == 'T') {
                for (int j = 0; j < m; j++) {
                    if (s[i + j] == 0) {
                        s[i + j] = s2[j];
                    } else if (s[i + j] != s2[j]) {
                        return "";
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (s1[i] == 'F') {
                int candidate = -1;
                boolean equal = true;
                for (int j = 0; j < m; j++) {
                    if (s[i + j] != 0) {
                        if (s[i + j] != s2[j]) {
                            equal = false;
                            break;
                        }
                        continue;
                    }
                    candidate = j;
                    if (s2[j] != 'a') {
                        break;
                    }
                }
                if (equal && candidate == -1) {
                    return "";
                }
                if (equal) {
                    s[i + candidate] = s2[candidate] == 'a' ? 'b' : 'a';
                }
            }
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 0) {
                s[i] = 'a';
            }
        }
        return new String(s);
    }
}