package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems30;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
 *
 * 串联所有单词的子串
 * 难度 困难
 * 
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 * 提示:
 *   1 <= s.length <= 10^4
 *   s consists of lower-case English letters.
 *   1 <= words.length <= 5000
 *   1 <= words[i].length <= 30
 *   words[i] consists of lower-case English letters.
 *
 */
public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(findSubstring("foobarfoobar", new String[]{"foo","bar"}));
        System.out.println(findSubstring("a", new String[]{"a"}));
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"foo","bar"}));
        System.out.println(findSubstring("bcabbcaabbccacacbabccacaabacbbb", new String[]{"c","b","a","c","a","a","a","b","c"}));
    }

    /**
     * 不按套路出牌法：
     *
     * 我们可以先在原字符串中找到一个单词，记录起始和结束下标，
     * 然后向前和向后分别取单词长度个字符与 words 中的单词比对，比对成功则在原集合中移除此单词（需考虑同词多次出现的情况）
     * 直到前后的字符串都不是 words 中的单词，然后看是否还存在未匹配的单词,
     * 如果不存在未匹配的单词，则两下标间则为我们所需要的子串，起始下标则为所求。
     *
     * 继续在原字符串中找该单词出现的下一个位置，重复如上逻辑。
     * 直至不存在下个位置为止。
     *
     * 特殊：所有单词的串联长度超过字符串长度 直接返回空
     *
     * 这种思路需判断单词都在当前单词左边，单词都在当前单词右边，单词在单词左右两侧(可能有多种情况)，可优化实现。
     *
     * 执行用时： 2013 ms , 在所有 Java 提交中击败了 5.01% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 6.53% 的用户
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        int length = words.length;
        String word = words[0];
        int wordLength = word.length();
        int strLength = s.length();
        //所有单词的串联长度
        int totalLength = length * wordLength;
        List<Integer> resp = new ArrayList<>();
        if (strLength < totalLength){
            return resp;
        }
        List<String> strings = Arrays.asList(words);
        List<String> list = new LinkedList<>(strings);

        int preIndex = -1;
        while (true){
            int currIndex;
            // 找到首个单词的首次出现位置
            if (preIndex == -1){
                currIndex = s.indexOf(word);
            } else {
                currIndex = s.substring(preIndex + 1).indexOf(word);
            }
            // 该元素未出现过 直接返回空
            if (currIndex == -1){
                return resp;
            }
            //当前元素在原字符串中的下标
            currIndex += preIndex + 1;
            // 匹配单词 从集合从移除当前单词
            list.remove(word);
            /** 单词的开始下标 */;
            int left = currIndex;
            /** 单词的结束下标 */
            int right = left + wordLength;

            List<String> leftCol = new LinkedList<>();
            while (left - wordLength > -1){
                String substring = s.substring(left - wordLength, left);
                if (!list.contains(substring)){
                    break;
                }
                //从集合从移除当前单词
                list.remove(substring);
                leftCol.add(substring);
                //左移下标
                left = left - wordLength;
            }
            //其他单词全部在当前单词左边
            if (list.isEmpty()){
                if (!resp.contains(left)){
                    resp.add(left);
                }
                //如果单词全在左边 清空左侧出现的单词集合 重新初始化集合 继续判断存不存在单词全在右边的情况
                leftCol.clear();
                list = new ArrayList<>(strings);
                // 匹配单词 从集合从移除当前单词
                list.remove(word);
            }
            while (right + wordLength <= strLength){
                String substring = s.substring(right, right + wordLength);
                if (!list.contains(substring)){
                   break;
                }
                //从集合从移除当前单词
                list.remove(substring);
                //右移下标
                right = right + wordLength;
            }
            if (list.isEmpty()){
                if (leftCol.isEmpty()){
                    //单词都在右边
                    if (!resp.contains(currIndex)){
                        resp.add(currIndex);
                    }
                } else {
                    //单词左右都有  仍需判断是否有全在右边的情况
                    if (!resp.contains(left)){
                        resp.add(left);
                    }
                    //判断下标右移的时候 是不是每个移入单词都等于左侧移出单词
                    boolean isAlwaysEqual = true;
                    //继续右移右侧下标
                    while (right + wordLength <= strLength){
                        String rightWord = s.substring(right, right + wordLength);
                        if (!leftCol.contains(rightWord)){
                            break;
                        }
                        String leftWord = s.substring(left, left + wordLength);
                        //左移下标
                        left = left + wordLength;
                        //如果每次右移的这个单词正好等于左侧移出的单词
                        if (isAlwaysEqual && leftWord.equals(rightWord)) {
                            if (!resp.contains(left)){
                                resp.add(left);
                            }
                        } else {
                            isAlwaysEqual = false;
                        }
                        //从集合从移除当前单词
                        leftCol.remove(rightWord);
                        //右移下标
                        right = right + wordLength;
                    }
                    if (leftCol.isEmpty()){
                        //单词都在右边
                        if (!resp.contains(currIndex)){
                            resp.add(currIndex);
                        }
                    }
                }
            }
            list = new LinkedList<>(strings);
            preIndex = currIndex;
            //如果当前下标已经到了字符串最后一位 直接退出循环
            if (currIndex == strLength - 1){
                break;
            }
        }
        return resp;
    }
}

/**
 * 20ms beats 61.11%
 */
class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        final int wordLen = words[0].length();
        final int length = s.length();
        final int wordSize = words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> differs = new HashMap<>();
            if (length - i < wordLen * wordSize) {
                break;
            }
            for (int j = 0; j < wordSize; j++) {
                final String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                differs.put(word, differs.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differs.put(word, differs.getOrDefault(word, 0) - 1);
                if (differs.get(word) == 0) {
                    differs.remove(word);
                }
            }
            for (int start = i; start <= length - wordSize * wordLen; start += wordLen) {
                if (start != i) {
                    final String w1 = s.substring(start - wordLen, start);
                    differs.put(w1, differs.getOrDefault(w1, 0) - 1);
                    if (differs.get(w1) == 0) {
                        differs.remove(w1);
                    }
                    final String w2 = s.substring(start + (wordSize - 1) * wordLen, start + wordSize * wordLen);
                    differs.put(w2, differs.getOrDefault(w2, 0) + 1);
                    if (differs.get(w2) == 0) {
                        differs.remove(w2);
                    }
                }
                if (differs.isEmpty()) {
                    res.add(start);
                }
            }
        }
        return res;
    }
}