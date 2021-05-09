package com.github.zhuo.algorithm.weekly;

public class MaximumPopulationYear {

    public static void main(String[] args) {
        System.out.println(maximumPopulation(new int[][]{{1993,1999}, {2000,2010}}));
        System.out.println(maximumPopulation(new int[][]{{1950,1961},{1960,1971},{1970,1981}}));
        //2022
        System.out.println(maximumPopulation(new int[][]{{1982,1998},{2013,2042},{2010,2035},{2022,2050},{2047,2048}}));
    }

    //人口最多的年份
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
