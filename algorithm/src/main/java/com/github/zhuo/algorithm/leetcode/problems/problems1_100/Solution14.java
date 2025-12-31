package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * 最长公共前缀
 */
public class Solution14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

    /**
     * 横向或纵向比对字符串
     * 本解法是横向比对，两两比对字符串，取公共部分，
     * 用公共部分再和下一个字符串两两比对取公共部分。直至循环比对完毕或者公共部分为空串。
     *
     * 时间复杂度 O(mn) m 为数组的长度  n 为字符串的平均长度。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0){
            return "";
        }
        //取出每个字符串
        String commonStr = strs[0];
        for (int i = 1, len = strs.length; i < len; i++) {
            //如果公共部分不存在 直接退出
            int commonLength = commonStr.length();
            if (commonLength < 1){
                break;
            }
            String str = strs[i];
            //获取当前字符串和上一个字符串的公共部分
            //用公共部分和下一个字符串继续取公共部分,循环较短字符串即可
            for (int j = 0; j < commonLength; j++) {
                if (commonLength > str.length() && j == str.length()){
                    commonStr = str;
                    break;
                }
                if (str.charAt(j) != commonStr.charAt(j)){
                    commonStr = str.substring(0, j);
                    break;
                }
            }
        }
        return commonStr;
    }

}
