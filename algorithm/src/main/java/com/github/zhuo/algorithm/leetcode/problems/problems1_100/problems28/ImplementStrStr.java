package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems28;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * 实现 strStr()
 *
 * 难度 简单
 * 
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 *
 * 说明：
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 *
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }

    /**
     * 双指针
     * 执行用时： 181 ms , 在所有 Java 提交中击败了 5.01% 的用户
     * 内存消耗： 39 MB , 在所有 Java 提交中击败了 5.09% 的用户
     *
     * 效率较差 需继续优化
     */
    public static int strStr(String haystack, String needle) {
        int sLen = haystack.length();
        int iLen = needle.length();
        if (iLen == 0){
            return 0;
        }
        int index = 0;
        int start = 0;
        int needleIndex = 0;
        while (sLen - start >= iLen - needleIndex) {
            if (needleIndex == iLen){
                return start;
            }
            System.out.print(" " + index);
            System.out.println(" need:" + needleIndex);
            if(haystack.charAt(index) == needle.charAt(needleIndex)){
                index ++;
                needleIndex ++;
            } else {
                start += 1;
                index = start;
                needleIndex = 0;
            }
        }
        return needleIndex == iLen ? start : -1;
    }
}
