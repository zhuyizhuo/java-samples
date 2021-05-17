package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900.problems1854;

/**
 * https://leetcode-cn.com/problems/maximum-population-year/
 * 人口最多的年份
 * 难度 简单
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 *
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 *
 * 返回 人口最多 且 最早 的年份。
 *
 * 提示：
 *
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 */
public class MaximumPopulationYear {

    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{1993,1999}, {2000,2010}}));
        System.out.println(maximumPopulation(new int[][]{{1950,1961},{1960,1971},{1970,1981}}));
        //2022
        System.out.println(maximumPopulation(new int[][]{{1982,1998},{2013,2042},{2010,2035},{2022,2050},{2047,2048}}));
    }

    public static int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        for (int i = 0; i < logs.length; i++) {
            for (int j = logs[i][0]; j < logs[i][1]; j++) {
                years[j-1950] = years[j-1950] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < years.length; i++) {
            if (years[i] > years[max]){
                max = i;
            }
        }
        return max + 1950;
    }

}
