package com.github.zhuo.algorithm.weekly.problems5701;

/**
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：
 * 选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 *
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 */
public class Solution1 {

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("attack", "defend"));
        System.out.println(areAlmostEqual("kelb", "kelb"));
        System.out.println(areAlmostEqual("abcd", "dcba"));
        System.out.println(areAlmostEqual("abcdccccc", "cbcdacccc"));
        System.out.println(areAlmostEqual("bababa", "abbaba"));
        System.out.println(areAlmostEqual("bababa", "ababab"));
    }
    /**
     * 要确认字符串中所有字符都一样。
     * 有公共的最长子串。
     *
     * aaaaaaacbbbbbbbbbb  bbbbbbbbbbcaaaaaaa
     * abcd   dabc
     * bababa  abbaba
     * abcdccccc     cbcdacccc
     */
    public static boolean areAlmostEqual(String s1, String s2) {
        //如果两个字符串已经相等 直接返回成功
        if(s1.equals(s2)){
            return true;
        }
        //字母表共26个字母，将字符串映射至数组
        int[] chars = new int[26];
        int[] s2Chars = new int[26];
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            chars[s1.charAt(i)-'a'] += 1;
            s2Chars[s2.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            //如果两个字符串中的想同字母的数量不一致 直接返回失败
            if (chars[i] != s2Chars[i]){
                return false;
            }
        }
        int count = 2;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                count--;
            }
            if (count < 0){
                return false;
            }
        }
        return true;
    }

}
