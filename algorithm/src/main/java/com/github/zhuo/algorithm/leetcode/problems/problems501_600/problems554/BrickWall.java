package com.github.zhuo.algorithm.leetcode.problems.problems501_600.problems554;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/brick-wall/
 * 砖墙
 * 难度 中等
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 *
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 *
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 * 提示：
 *
 * n == wall.length
 * 1 <= n <= 10^4
 * 1 <= wall[i].length <= 10^4
 * 1 <= sum(wall[i].length) <= 2 * 10^4
 * 对于每一行 i ，sum(wall[i]) 应当是相同的
 * 1 <= wall[i][j] <= 2^(31 - 1)
 */
public class BrickWall {

    public static void main(String[] args) {
        List<List<Integer>> l = new ArrayList<>();
//        String s = "[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]";
        String s = "[1],[1],[1]";
        String[] split = s.split("],");
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].replaceAll("\\[", "").replaceAll("]", "").split(",");
            List<Integer> inner = new ArrayList<>();
            for (int j = 0; j < split1.length; j++) {
                inner.add(Integer.parseInt(split1[j]));
            }
            l.add(inner);
        }
        System.out.println(leastBricks(l));
    }

    /**
     * 思路
     *  题目可理解为砖墙从上到下且从左到右，相加之和相等的最大层数，返回的穿过的砖数等于总层数减去最大层数。
     *
     * 执行用时： 14 ms , 在所有 Java 提交中击败了 83.74% 的用户
     * 内存消耗： 41.5 MB , 在所有 Java 提交中击败了 66.83% 的用户
     */
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            List<Integer> integers = wall.get(i);
            for (int j = 0; j < integers.size() - 1; j++) {
                sum += integers.get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (Integer key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        return wall.size() - max;
    }
}
