package com.github.zhuo.algorithm.leetcode.problems.problems1201_1300;

/**
 * https://leetcode-cn.com/problems/get-equal-substrings-within-budget/
 *
 * 尽可能使字符串相等
 * 
 * 给你两个长度相同的字符串，s 和 t。
 *
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 *
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 *
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 *
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 *
 */
public class Solution1208 {

    public static void main(String[] args) {
        Solution1208 solution1208 = new Solution1208();
        System.out.println(solution1208.equalSubstring("abcd","bcdf", 3));//3
        System.out.println(solution1208.equalSubstring("abcd","cdef", 3));//1
        System.out.println(solution1208.equalSubstring("abcd","acde", 0));//1
    }

    /**
     * 5ms beats 91.37%
     */
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int[] diff =new int[n];
        for(int i=0;i<n;i++){
            diff[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        int maxlength =0;
        int start=0,end =0;
        int curcost=0;
        while(end<n){
            curcost +=diff[end];
            if(curcost>maxCost){
                curcost-=diff[start];
                start++;
            }
            maxlength=Math.max(maxlength,end-start+1);
            end++;
        }
        return maxlength;
    }

}
