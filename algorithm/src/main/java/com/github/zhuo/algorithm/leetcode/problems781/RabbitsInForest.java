package com.github.zhuo.algorithm.leetcode.problems781;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/rabbits-in-forest/
 * 难度 中等
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。
 * 我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 */
public class RabbitsInForest {

    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1,1,2}));
        System.out.println(numRabbits(new int[]{1,0,1,0,0}));
        System.out.println(numRabbits(new int[]{10,10,10}));
        System.out.println(numRabbits(new int[]{}));
    }

    /**
     * 思路
     * 将回答数量相同的兔子归为一组，但不能超过 数量+1 的总数
     * 如果超过 数量+1 的总数，则需统计原数量总数，并初始化该组数量为1
     * 最后把 数量+1 循环相加
     *
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 50.38% 的用户
     * 内存消耗： 37.8 MB , 在所有 Java 提交中击败了 66.67% 的用户
     */
    public static int numRabbits1(int[] answers) {
        Map<Integer, Integer> rabbitMap = new HashMap<>();
        int total = 0;
        for (int i = 0; i < answers.length; i++) {
            Integer integer = rabbitMap.get(answers[i]);
            if (integer == null){
                rabbitMap.put(answers[i], 1);
            } else {
                if (integer > answers[i]){
                    total += integer;
                    rabbitMap.put(answers[i], 1);
                } else {
                    rabbitMap.put(answers[i], integer + 1);
                }
            }
        }
        for (Integer integer : rabbitMap.keySet()) {
            total += integer + 1;
        }
        return total;
    }

    /**
     * 基于上述题解优化 使用数组代替 map
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 77.65% 的用户
     * 内存消耗： 37.7 MB , 在所有 Java 提交中击败了 73.86% 的用户
     */
    public static int numRabbits(int[] answers) {
        int[] rabbitMap = new int[1000];
        Arrays.fill(rabbitMap, -1);
        int total = 0;
        for (int i = 0; i < answers.length; i++) {
            if (rabbitMap[answers[i]] > answers[i]){
                total += rabbitMap[answers[i]];
                rabbitMap[answers[i]] = 1;
            } else if (rabbitMap[answers[i]] == -1){
                rabbitMap[answers[i]] = 1;
            } else {
                rabbitMap[answers[i]] += 1;
            }
        }
        for (int i = 0; i < 1000; i++) {
            if (rabbitMap[i] != -1){
                total += i+1;
            }
        }
        return total;
    }

}
