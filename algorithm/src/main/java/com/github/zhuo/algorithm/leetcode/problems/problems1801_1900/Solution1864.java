package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

public class Solution1864 {

    public static void main(String[] args) {
        //1
        System.out.println(minSwaps("111000"));
        //0
        System.out.println(minSwaps("010"));
        //-1
        System.out.println(minSwaps("1110"));
        //1
        System.out.println(minSwaps("100"));
        //1
        System.out.println(minSwaps("0010111"));
        //1010101
        System.out.println(minSwaps("1111000"));
        System.out.println(minSwaps("1111100"));
        System.out.println(minSwaps("1001001"));
    }

    public static int minSwaps(String s) {
        int[] count = new int[2];
        int total = '0' + '1';
        char[] chars = s.toCharArray();
        int shouldBe = total - chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != shouldBe){
                count['1' - chars[i]]++;
            }
            shouldBe = total - shouldBe;
        }
        if (s.length() == 3){
            if (count[0] == 1 || count[1] == 1){
                return 1;
            }
        }
        if (count[0] != count[1]){
            return -1;
        }
        return count[0];
    }
}
