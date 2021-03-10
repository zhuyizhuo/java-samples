package com.github.zhuo.algorithm.leetcode.problems1_100.problems58;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class LengthOfLastWord1 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" tre "));
    }

    /**
     *  " abc dcs"
     *  "abc  "
     *  "avc ds "
     *  " tre "
     *  思路：转换为从后向前找 并且过滤掉起始的空格
     *  执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     */
    public static int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' '){
                //如果是开头的空格 则继续
                if (length == 0){
                    continue;
                } else {
                    //如果已经查找到字符又遇到空格，说明单词结束 直接返回长度即可
                    return length;
                }
            }
            length ++;
        }
        return length;
    }

}
