package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * 无重复字符的最长子串
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 *
 * Constraints:
 *
 * 0 <= s.length <= 50000
 * s consists of English letters, digits, symbols and spaces.
 */
public class Solution3 {

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int beginIndex = 0;
        int max = 1;
        char key;
        for (int i = 1,len = s.length(); i < len; i++) {
            key = s.charAt(i);
            Integer index = map.get(key);
            if (index != null && index >= beginIndex){
                beginIndex = index + 1;
            } else {
                max = Math.max(max, i - beginIndex + 1);
            }
            map.put(key, i);
        }
        return max;
    }
}
