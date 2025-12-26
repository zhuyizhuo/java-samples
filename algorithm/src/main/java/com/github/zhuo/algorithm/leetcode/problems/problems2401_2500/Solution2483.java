package com.github.zhuo.algorithm.leetcode.problems.problems2401_2500;

public class Solution2483 {
    public int bestClosingTime(String customers) {
        char[] s = customers.toCharArray();
        int penalty = 0;
        for (char c : s) {
            if (c == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int ans = 0; // [0,n-1] 是第二段
        for (int i = 0; i < s.length; i++) {
            penalty += s[i] == 'N' ? 1 : -1;
            if (penalty < minPenalty) {
                minPenalty = penalty;
                ans = i + 1; // [0,i] 是第一段，[i+1,n-1] 是第二段
            }
        }
        return ans;
    }
}

/**
 * beats 100%  depends on commit running time
 */
class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int maxline = 0;
        int line = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            char cur = customers.charAt(i);
            if (cur == 'Y') {
                line ++;
                if (line > maxline) {
                    result = i + 1;
                    maxline = line;
                }
            } else {
                line --;
            }
        }
        return result;
    }
}