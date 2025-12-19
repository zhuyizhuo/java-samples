package com.github.zhuo.algorithm.leetcode.problems.problems1401_1500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant/
 * 点菜展示表
 * 难度 中等
 *
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，
 * 其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 *
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，
 * 后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 *
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 *
 */
public class Solution1418 {

    public static void main(String[] args) {
        List s = new ArrayList();
        s.add("David");
        s.add("3");
        s.add("Ceviche");

        List s1 = new ArrayList();
        s1.add("Corina");
        s1.add("10");
        s1.add("Beef Burrito");

        List s2 = new ArrayList();
        s2.add("David");
        s2.add("3");
        s2.add("Fried Chicken");

        List s3 = new ArrayList();
        s3.add("Carla");
        s3.add("5");
        s3.add("Water");

        List s4 = new ArrayList();
        s4.add("Carla");
        s4.add("5");
        s4.add("Ceviche");

        List s5 = new ArrayList();
        s5.add("Rous");
        s5.add("3");
        s5.add("Ceviche");
        List<List<String>> a = new ArrayList<>();
        a.add(s);
        a.add(s1);
        a.add(s2);
        a.add(s3);
        a.add(s4);
        a.add(s5);
        List<List<String>> x = displayTable(a);
        for (int i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
    }

    /**
     * 朴素的实现
     * 执行用时： 106 ms , 在所有 Java 提交中击败了 8.43% 的用户
     * 内存消耗： 65.1 MB , 在所有 Java 提交中击败了 7.23% 的用户
     */
    public static List<List<String>> displayTable(List<List<String>> orders) {
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap(Comparator.comparingInt(o -> Integer.parseInt((String) o)));
        List<String> allFoodList = new ArrayList();
        for (int i = 0; i < orders.size(); i++) {
            List<String> strings = orders.get(i);
            String tableNum = strings.get(1);
            String food = strings.get(2);
            if (!allFoodList.contains(food)){
                allFoodList.add(food);
            }
            TreeMap<String, Integer> allFood = map.getOrDefault(tableNum, new TreeMap<>());
            allFood.put(food, allFood.getOrDefault(food, 0) + 1);
            map.put(tableNum, allFood);
        }
        List<List<String>> resp = new ArrayList();
        Collections.sort(allFoodList, Comparator.naturalOrder());
        allFoodList.add(0, "Table");
        resp.add(allFoodList);
        for (Map.Entry<String, TreeMap<String, Integer>> stringMapEntry : map.entrySet()) {
            List<String> inner = new ArrayList<>();
            inner.add(stringMapEntry.getKey());
            for (int i = 1; i < allFoodList.size(); i++) {
                inner.add(stringMapEntry.getValue().getOrDefault(allFoodList.get(i), 0).toString());
            }
            resp.add(inner);
        }
        return resp;
    }
}
