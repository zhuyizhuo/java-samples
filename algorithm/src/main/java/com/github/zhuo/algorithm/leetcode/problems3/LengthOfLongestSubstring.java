package com.github.zhuo.algorithm.leetcode.problems3;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Given a string s, find the length of the longest substring without repeating characters.
 *
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
 * 0 <= s.length <= 5000
 * s consists of English letters, digits, symbols and spaces.
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

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
