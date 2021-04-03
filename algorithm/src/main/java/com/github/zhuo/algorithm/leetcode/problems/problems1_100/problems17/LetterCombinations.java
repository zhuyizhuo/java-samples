package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems17;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 *
 * 电话号码的字母组合
 */
public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println();
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return new ArrayList<>();
        }
        List l = new ArrayList();
        char c = digits.charAt(0);
        String[] str = getStr(c);
        for (int j = 0; j < str.length; j++) {
            l.add(str[j]);
        }
        for (int i = 1; i < digits.length(); i++) {
            String[] str1 = getStr(digits.charAt(i));
            List temp = new ArrayList(l);
            l.clear();
            for (int j = 0; j < temp.size(); j++) {
                for (int k = 0; k < str1.length; k++) {
                    l.add(temp.get(j) + str1[k]);
                }   
            }
        }
        return l;
    }

    public String[] getStr(char str){
        switch (str){
            case '2':
                return new String[]{"a","b","c"};
            case '3':
                return new String[]{"d","e","f"};
            case '4':
                return new String[]{"g","h","i"};
            case '5':
                return new String[]{"j","k","l"};
            case '6':
                return new String[]{"m","n","o"};
            case '7':
                return new String[]{"p","q","r","s"};
            case '8':
                return new String[]{"t","u","v"};
            case '9':
                return new String[]{"w","x","y","z"};
        }
        return new String[]{};
    }
}
