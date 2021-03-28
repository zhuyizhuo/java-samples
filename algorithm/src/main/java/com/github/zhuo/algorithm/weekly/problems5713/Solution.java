package com.github.zhuo.algorithm.weekly.problems5713;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("a1b01c001"));
        System.out.println(numDifferentIntegers("167278959591294"));
        System.out.println(numDifferentIntegers("035985750011523523129774573439111590559325"));
        System.out.println(numDifferentIntegers("0a0"));
    }

    public static int numDifferentIntegers(String word) {
        String[] split = word.split("[a-z]+");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].trim().length() > 0){
                int start = 0;
                while (start < split[i].length() - 1 && split[i].charAt(start) == '0'){
                    start++;
                }
                set.add(split[i].substring(start));
            }
        }
        return set.size();
    }
}
