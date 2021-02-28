package com.github.zhuo.algorithm.leetcode.problems1178;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/number-of-valid-words-for-each-puzzle/
 *
 * 猜字谜
 * 
 * 外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 * 提示：
 *   1 <= words.length <= 10^5
 *   4 <= words[i].length <= 50
 *   1 <= puzzles.length <= 10^4
 *   puzzles[i].length == 7
 *   words[i][j], puzzles[i][j] 都是小写英文字母。
 *   每个 puzzles[i] 所包含的字符都不重复。
 *
 */
public class NumberOfValidWordsForEachPuzzle {

    public static void main(String[] args) {
        //[1, 1, 3, 2, 4, 0]
        System.out.println(findNumOfValidWords(new String[]{"aaaa","asas","able","ability","actt","actor","access"}, new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}));
        //[0,1,3,2,0]
        System.out.println(findNumOfValidWords(new String[]{"apple","pleas","please"}, new String[]{"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"}));
    }

    /**
     *  暴力解法时间超限，参考了官方题解思路。
     *
     *  优化暴力解法的思路：单词中出现的重复字符仅需判断一次，对单词去重后的结果只要在原谜面中全部存在即可。
     *
     *  即 aaaa 与 a 可视为同一个单词, aaabbc 与 abc 也可视为同一个单词。
     *
     *  由题意可知 words[i][j], puzzles[i][j] 都仅包含小写英文字母，所以不同的字母最多出现26个，
     *  我们可以将小写英文字母编码为 0-25
     *  用一个26位的二进制数将单词中的每个字母映射进去，如果字母出现，则把对应位数的值标为1。
     *
     * 执行用时: 86 ms  超过了 67% 的 JAVA 提交记录
     * 内存消耗: 53.5 MB
     */
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int length = words.length;
        //键为 word 映射出的二进制数 值为出现次数
        Map<Integer, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char[] chars = words[i].toCharArray();
            int key = 0;
            for (int j = 0; j < chars.length; j++) {
                //把对应的位置设为1
                int num = 1 << (chars[j]-'a');
                key |= num;
            }
            Integer integer = wordMap.get(key);
            if (integer == null){
                wordMap.put(key, 1);
            } else {
                wordMap.put(key, integer + 1);
            }
        }
        List<Integer> resp = new ArrayList<>();
        int puzzleLen = puzzles.length;
        for (int i = 0; i < puzzleLen; i++) {
            char[] chars = puzzles[i].toCharArray();
            int key = 0;
            for (int j = 0; j < 7; j++) {
                key |= 1 << (chars[j] - 'a');
            }
            //首字母的出现位置 子集的该位必须是1
            int mark = 1 << chars[0] - 'a';
            int subSet = key;
            int sum = 0;
            while (subSet != 0){
                if ((subSet & mark) == mark){
                    sum += wordMap.getOrDefault(subSet, 0);
                }
                subSet = (subSet - 1)&key;
            }
            resp.add(sum);
        }
        return resp;
    }

}
