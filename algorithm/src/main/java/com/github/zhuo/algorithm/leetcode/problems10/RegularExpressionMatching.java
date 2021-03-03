package com.github.zhuo.algorithm.leetcode.problems10;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * 正则表达式匹配
 * 难度:困难
 * 
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 示例 1：
 *
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 *
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        //todo
        System.out.println(isMatch("aasdfadsfasdfasfb", ".*b"));
        //true
        System.out.println(isMatch("aab", "c*a*b"));

        System.out.println();
    }

    public static boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        char lastChar = p.charAt(0);
        int length = s.length();
        int pLength = p.length();
        while (sIndex < length) {
            if (pIndex == pLength){
                return false;
            }
            char c = s.charAt(sIndex);
            char c1 = p.charAt(pIndex);
            // 匹配任意单个字符 跳过当前字符的比对
            if (c1 == '.'){
                sIndex++;
                pIndex++;
                lastChar = c1;
                continue;
            } else if (c1 == '*'){
                //如果上一个字符是. 则跳过当前字符比对
                if (lastChar == '.'){
                    sIndex++;
                    continue;
                }
                // 匹配零个或多个前面的那一个元素
                if (c != lastChar){
                    //未匹配上则和正则下一个字符匹配
                    pIndex++;
                    continue;
                }
                //匹配上了则匹配下一个字符
                sIndex++;
            } else {
                //比对当前字符是否匹配
                //如果上一个字符是. 则跳过当前字符
                if (lastChar == '.'){
                    sIndex++;
                    continue;
                }
                if (c != c1){
                    return false;
                }
                sIndex++;
                pIndex++;
                lastChar = c1;
            }
        }
        return pIndex == pLength - 1;
    }
}
