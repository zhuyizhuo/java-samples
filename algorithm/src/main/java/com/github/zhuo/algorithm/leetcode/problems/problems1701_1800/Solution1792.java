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
        Solution1792 solution1792 = new Solution1792();
        System.out.println(solution1792.maxAverageRatio(new int[][]{{1,2},{3,5},{2,2}}, 2));
        System.out.println(solution1792.maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}}, 4));
    }

    static double THRES = 0.0000000009;

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        double left = 0, right = 1, mid;
        while(right - left >= THRES) {
            mid = (left + right) / 2;
            int extra = 0;
            for(int i = 0; i < classes.length; i++) {
                int notPass = classes[i][1] - classes[i][0];
                if (notPass == 0) {
                    continue;
                }
                extra += Math.max(Math.sqrt(notPass / mid) - classes[i][1], 0);
            }
            if (extra <= extraStudents) {
                right = mid;
            }
            else {
                left = mid;
            }
        }
        double ret = 0;
        for(int i = 0; i < classes.length; i++) {
            int notPass = classes[i][1] - classes[i][0];
            if (notPass == 0) {
                ret += 1;
                continue;
            }
            int total = (int)(Math.sqrt(notPass / right));
            int addedStudent = Math.max(total, classes[i][1]) - classes[i][1];
            classes[i][1] += addedStudent;
            classes[i][0] += addedStudent;
            // System.out.println(classes[i][0]+ ", " + classes[i][1]);
            ret += (double)(classes[i][0]) / classes[i][1];
            extraStudents -= addedStudent;
        }
        // System.out.println(extraStudents);
        for (int i = 0; i < extraStudents; i++) {
            ret += (double)(classes[i][1] - classes[i][0]) / classes[i][1] / (classes[i][1] + 1);
        }
        return ret / classes.length;
    }
}