package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/evaluate-the-bracket-pairs-of-a-string/
 * 替换字符串中的括号内容
 * 难度 中等
 * 
 * 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
 *
 * 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
 * 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
 *
 * 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
 *
 * 将 keyi 和括号用对应的值 valuei 替换。
 * 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
 * knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
 *
 * 请你返回替换 所有 括号对后的结果字符串。
 * 
 * 提示：
 *
 * 1 <= s.length <= 105
 * 0 <= knowledge.length <= 105
 * knowledge[i].length == 2
 * 1 <= keyi.length, valuei.length <= 10
 * s 只包含小写英文字母和圆括号 '(' 和 ')' 。
 * s 中每一个左圆括号 '(' 都有对应的右圆括号 ')' 。
 * s 中每对括号内的键都不会为空。
 * s 中不会有嵌套括号对。
 * keyi 和 valuei 只包含小写英文字母。
 * knowledge 中的 keyi 不会重复。
 *
 */
public class Solution1807 {

    public static void main(String[] args) {
//        List<List<String>> list = getList(new String[][]{{"name","bob"},{"age","two"}});
//        System.out.println(evaluate("(name)is(age)yearsold", list));
//        List<List<String>> list = getList(new String[][]{{"a","b"}});
//        System.out.println(evaluate("hi(name)", list));
//        List<List<String>> list = getList(new String[][]{{"a","yes"}});
//        System.out.println(evaluate("(a)(a)(a)aaa", list));
        List<List<String>> list = getList(new String[][]{{"a","b"},{"b","a"}});
        System.out.println(evaluate("(a)(b)", list));
    }

    private static List<List<String>> getList(String[][] strings) {
        List<List<String>> resp = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            ArrayList<String> objects = new ArrayList<>();
            objects.add(strings[i][0]);
            objects.add(strings[i][1]);
            resp.add(objects);
        }
        return resp;
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            List<String> strings = knowledge.get(i);
            map.put(strings.get(0), strings.get(1));
        }
        String s2 = s.replaceAll("\\(", ")(");
        String[] split = s2.split("\\)");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (split[i].startsWith("(")){
                String s1 = map.get(split[i].substring(1));
                if (s1 == null){
                    sb.append("?");
                } else {
                    sb.append(s1);
                }
            } else {
                sb.append(split[i]);
            }
        }
        return sb.toString();
    }
}
