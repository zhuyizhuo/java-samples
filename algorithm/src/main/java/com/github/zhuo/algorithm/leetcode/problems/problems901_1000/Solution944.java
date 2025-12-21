package com.github.zhuo.algorithm.leetcode.problems.problems901_1000;

/**
 *
 */
public class Solution944 {


    public static void main(String[] args) {
        System.out.println(new Solution944().minDeletionSize1(new String[]{"cba","daf","ghi"}));
    }

    public int minDeletionSize(String[] strs) {
        if (strs.length == 1){
            return 0;
        }
        int length = strs[0].length();

        String[] s = new String[length];
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                s[j] = (s[j]==null? "" : s[j]) + charArray[j];
            }
        }
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
            char[] charArray = s[i].toCharArray();
            for (int j = 1; j < charArray.length; j++) {
                if (charArray[j] - charArray[j-1] < 0){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int minDeletionSize1(String[] strs) {
        int length = strs.length;
        int size = strs[0].length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < length; j++) {
                if (strs[j-1].charAt(i) > strs[j].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
