package com.github.zhuo.algorithm.weekly.problems5703;

public class Solution {
    public static void main(String[] args) {
//        int[][] ints = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
//        for (int i = 0; i < ints.length; i++) {
//            System.out.print(ints[i][0]*1.0/ints[i][1] + " ");
//            System.out.print((ints[i][0]+1)*1.0/(ints[i][1]+1) + " ");
//            System.out.print((ints[i][0]+2)*1.0/(ints[i][1]+2) + " ");
//            System.out.print((ints[i][0]+3)*1.0/(ints[i][1]+3) + " ");
//            System.out.print((ints[i][0]+4)*1.0/(ints[i][1]+4) + " ");
//            System.out.println();
//        }
//        System.out.println((0.75+0.5384615384615384+0.8888888888888888+0.42857142857142855)/4);
        System.out.println(maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}}, 2));
        System.out.println(maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}}, 4));
    }

    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        double max = -1.0;
        double maxPlus = 0;
        double sum = 0;
        double origin = 0;
        int length = classes.length;
        for (int i = 0; i < length; i++) {
            double v = classes[i][0] * 1.0 / classes[i][1];
            double newV = (classes[i][0] + extraStudents) * 1.0 /(classes[i][1] + extraStudents);
            if (newV - v > maxPlus || max == -1.0){
                maxPlus = newV - v;
                max = newV;
                origin = v;
            }
            sum += v;
        }
        return (sum - origin + max)/length;
    }
}
