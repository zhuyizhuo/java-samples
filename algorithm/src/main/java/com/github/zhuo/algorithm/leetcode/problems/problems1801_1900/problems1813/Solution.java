package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900.problems1813;

import java.util.Arrays;
import java.util.List;


public class Solution {

    public static void main(String[] args) {
//        System.out.println(areSentencesSimilar("My name is Haley", "My Haley"));
//        System.out.println(areSentencesSimilar("of", "A lot of words"));
//        System.out.println(areSentencesSimilar("Eating right now", "Eating"));
//        System.out.println(areSentencesSimilar("Luky", "Lucccky"));
//        System.out.println(areSentencesSimilar("A B", "A"));
        //false;
        System.out.println(areSentencesSimilar("B", "ByI BMyQIqce b bARkkMaABi vlR RLHhqjNzCN oXvyK zRXR q ff B yHS OD KkvJA P JdWksnH"));
    }

    /**
     * 执行用时: 2 ms  超过 36%
     */
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        //两个句子完全相等
        if (sentence1.equals(sentence2)){
            return true;
        }
        String[] s = sentence1.split(" ");
        String[] s1 = sentence2.split(" ");
        boolean b = s.length >= s1.length;
        if (b){
            if ((sentence1+" ").startsWith(sentence2+" ") || (sentence1+" ").endsWith(sentence2+" ")){
                return true;
            }
        } else {
            if ((sentence2+" ").startsWith(sentence1+" ") || (sentence2+" ").endsWith(sentence1+" ")){
                return true;
            }
        }
        List<String> bigList = Arrays.asList(b ? s : s1);
        List<String> smallList = Arrays.asList(b ? s1 : s);
        int start = 0;
        int end = smallList.size() - 1;
        while (start < smallList.size() && bigList.get(start).equals(smallList.get(start))){
            start++;
        }
        if (start == smallList.size()){
            return true;
        }
        int bigEnd = bigList.size() - 1;
        while (end >= 0 && bigList.get(bigEnd).equals(smallList.get(end))){
            end--;
            bigEnd--;
            start++;
        }
        if (start == smallList.size()){
            return true;
        }
        return false;
    }
}
