package com.github.zhuo.algorithm.leetcode.problems.problems401_500;

/**
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 *
 * 替换后的最长重复字符
 * 
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 10^4。
 */
public class Solution424 {

    public static void main(String[] args) {
        //todo
//        System.out.println(characterReplacement("ABBB",2));
        System.out.println(characterReplacement("CABCACBBB",2));
        System.out.println(characterReplacement("ABBBAA",2));
    }

    /**
     * 思路：
     *  滑动窗口
     */
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = left;
        //当前出现最多的字符数量
        int currMax = 0;
        int max = 0;
        char[] chars1 = s.toCharArray();
        int[] count = new int[26];
        int length = s.length();
        while (right < length){
            count[chars1[right] - 'A']++;
            currMax = Math.max(currMax, count[chars1[right] - 'A']);
            right++;
            if (right - left > currMax + k){
                count[chars1[left] - 'A']--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }


}
