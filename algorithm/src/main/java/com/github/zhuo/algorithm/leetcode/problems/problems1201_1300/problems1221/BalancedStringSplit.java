package com.github.zhuo.algorithm.leetcode.problems.problems1201_1300.problems1221;

/**
 * https://leetcode-cn.com/problems/split-a-string-in-balanced-strings/
 * 分割平衡字符串
 */
public class BalancedStringSplit {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
    }

    public static int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int countL = 0;
        int countR = 0;
        int countSplit = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'R') {
                countR++;
            } else {
                countL++;
            }
            if (countL == countR){
                countSplit++;
            }
        }
        return countSplit;
    }

}
