package com.github.zhuo.algorithm.leetcode.problems.problems1701_1800;

/**
 * https://leetcode-cn.com/problems/maximum-average-pass-ratio/
 * 最大平均通过率
 * 难度 中等
 * 
 * 一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。
 *
 * 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。
 *
 * 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。
 *
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10^-5 以内的结果都会视为正确结果。
 *
 * 提示：
 *
 * 1 <= classes.length <= 10^5
 * classes[i].length == 2
 * 1 <= passi <= totali <= 10^5
 * 1 <= extraStudents <= 10^5
 *
 */
public class Solution1792 {
    public static void main(String[] args) {
        //TODO 解法有误
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
