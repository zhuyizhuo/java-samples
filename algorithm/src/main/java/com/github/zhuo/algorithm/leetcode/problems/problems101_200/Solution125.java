package com.github.zhuo.algorithm.leetcode.problems.problems101_200;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 验证回文串
 * 难度 简单
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class Solution125 {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("0P"));
    }

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 65.07% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 62.52% 的用户
     */
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while (left < right){
            char c = s.charAt(left);
            if (!Character.isLetterOrDigit(c)) {
                left++;
                continue;
            }
            char c1 = s.charAt(right);
            if (!Character.isLetterOrDigit(c1)){
                right--;
                continue;
            }
            if (c != c1){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
