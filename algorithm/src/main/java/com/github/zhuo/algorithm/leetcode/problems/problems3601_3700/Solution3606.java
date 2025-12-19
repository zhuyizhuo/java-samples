package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

import java.util.*;

public class Solution3606 {

    public static void main(String[] args) {
        String[] code = {"SAVE20","","PHARMA5","SAVE@20"};
        String[] businessLine = {"restaurant","grocery","pharmacy","restaurant"};
        boolean[] isActive = {true,true,true,true};
        List<String> strings = validateCoupons(code, businessLine, isActive);
        System.out.println(strings);
    }

    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> rtnList = new ArrayList<>();
        Map<String,List<String>> m = new HashMap<>();
        m.put("electronics", new ArrayList<>());
        m.put("grocery", new ArrayList<>());
        m.put("pharmacy", new ArrayList<>());
        m.put("restaurant", new ArrayList<>());
        String regex = "^[a-zA-Z0-9_]+$";
        for (int i = 0; i < isActive.length; i++) {
            if (isActive[i]){
                if (m.containsKey(businessLine[i])){
                    String s = code[i];
                    if (s.matches("[a-zA-Z0-9_]+")){
                        m.get(businessLine[i]).add(s);
                    }
                }
            }
        }
        List<String> electronics = m.get("electronics");
        Collections.sort(electronics);
        rtnList.addAll(electronics);

        List<String> grocery = m.get("grocery");
        Collections.sort(grocery);
        rtnList.addAll(grocery);
        List<String> pharmacy = m.get("pharmacy");
        Collections.sort(pharmacy);
        rtnList.addAll(pharmacy);
        List<String> restaurant = m.get("restaurant");
        Collections.sort(restaurant);
        rtnList.addAll(restaurant);

        return rtnList;
    }
}
