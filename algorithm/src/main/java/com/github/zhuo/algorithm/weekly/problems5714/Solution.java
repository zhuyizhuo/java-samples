package com.github.zhuo.algorithm.weekly.problems5714;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

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
