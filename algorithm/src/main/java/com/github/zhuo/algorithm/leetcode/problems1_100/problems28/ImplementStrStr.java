package com.github.zhuo.algorithm.leetcode.problems1_100.problems28;

/**
 * https://leetcode.com/problems/implement-strstr/
 *
 * 实现 strStr()
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }

    /**
     * 双指针
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
