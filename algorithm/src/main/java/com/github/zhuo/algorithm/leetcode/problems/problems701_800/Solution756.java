package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 金字塔转换矩阵
 * 你正在把积木堆成金字塔。每个块都有一个颜色，用一个字母表示。每一行的块比它下面的行 少一个块 ，并且居中。
 *
 * 为了使金字塔美观，只有特定的 三角形图案 是允许的。一个三角形的图案由 两个块 和叠在上面的 单个块 组成。模式是以三个字母字符串的列表形式 allowed 给出的，其中模式的前两个字符分别表示左右底部块，第三个字符表示顶部块。
 *
 * 例如，"ABC" 表示一个三角形图案，其中一个 “C” 块堆叠在一个 'A' 块(左)和一个 'B' 块(右)之上。请注意，这与 "BAC" 不同，"B" 在左下角，"A" 在右下角。
 * 你从作为单个字符串给出的底部的一排积木 bottom 开始，必须 将其作为金字塔的底部。
 *
 * 在给定 bottom 和 allowed 的情况下，如果你能一直构建到金字塔顶部，使金字塔中的 每个三角形图案 都是在 allowed 中的，则返回 true ，否则返回 false 。
 */
public class Solution756 {

    public static void main(String[] args) {
        PyramidTransition pyramidTransition = new PyramidTransition();
        ArrayList<String> objects = new ArrayList<>();
        objects.add("BCC");
        objects.add("CDE");
        objects.add("CEA");
        objects.add("FFF");
        System.out.println(pyramidTransition.pyramidTransition("BCD", objects));
    }
}

/**
 * beats 100%
 */
class PyramidTransition {
    int[][] T;
    Set<Long> seen;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        T = new int[7][7];
        for (String a: allowed)
            T[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');

        seen = new HashSet();
        int N = bottom.length();
        int[][] A = new int[N][N];
        int t = 0;
        for (char c: bottom.toCharArray())
            A[N-1][t++] = c - 'A';
        return solve(A, 0, N-1, 0);
    }

    //A[i] - the ith row of the pyramid
    //R - integer representing the current row of the pyramid
    //N - length of current row we are calculating
    //i - index of how far in the current row we are calculating
    //Returns true iff pyramid can be built
    public boolean solve(int[][] A, long R, int N, int i) {
        if (N == 1 && i == 1) { // If successfully placed entire pyramid
            return true;
        } else if (i == N) {
            if (seen.contains(R)) return false; // If we've already tried this row, give up
            seen.add(R); // Add row to cache
            return solve(A, 0, N-1, 0); // Calculate next row
        } else {
            // w's jth bit is true iff block #j could be
            // a parent of A[N][i] and A[N][i+1]
            int w = T[A[N][i]][A[N][i+1]];
            // for each set bit in w...
            for (int b = 0; b < 7; ++b) if (((w >> b) & 1) != 0) {
                A[N-1][i] = b; //set parent to be equal to block #b
                //If rest of pyramid can be built, return true
                //R represents current row, now with ith bit set to b+1
                // in base 8.
                if (solve(A, R * 8 + (b+1), N, i+1)) return true;
            }
            return false;
        }
    }
}