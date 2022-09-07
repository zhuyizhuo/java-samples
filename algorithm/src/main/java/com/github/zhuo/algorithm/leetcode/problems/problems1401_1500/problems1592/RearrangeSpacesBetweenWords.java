package com.github.zhuo.algorithm.leetcode.problems.problems1401_1500.problems1592;

import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWords {

    public static void main(String[] args) {
//        String s = "  this   is  a sentence ";
//        String s = " practice   makes   perfect";
//        String s = "hello   world";
//        String s = "  walks  udp package   into  bar a";
        String s = "  hello"; //  --> "hello  "
        System.out.println("[" + reorderSpaces(s)+"]");
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 89.84% 的用户
     * 内存消耗： 39.4 MB , 在所有 Java 提交中击败了 76.82% 的用户
     * 通过测试用例： 89 / 89
     */
    public static String reorderSpaces(String text) {
        int spaceCount = 0;
        char[] chars = text.toCharArray();
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                spaceCount++;
                if (sb.length() > 0){
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(chars[i]);
            }
        }
        if (sb.length() > 0){
            words.add(sb.toString());
        }
        if (words.size() <= 1){
            String s = words.get(0);
            for (int i = 0; i < spaceCount; i++) {
                s += " ";
            }
            return s;
        }
        int space = spaceCount / (words.size() - 1);
        int otherSpace = spaceCount % (words.size() - 1);
        StringBuilder sbr = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            sbr.append(words.get(i));
            if (i < words.size() - 1){
                for (int j = 0; j < space; j++) {
                    sbr.append(" ");
                }
            }
        }
        for (int i = 0; i < otherSpace; i++) {
            sbr.append(" ");
        }
        return sbr.toString();
    }
}
