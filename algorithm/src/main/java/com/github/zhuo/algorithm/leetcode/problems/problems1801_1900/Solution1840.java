package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

import java.util.Arrays;

/**
 *  最高建筑高度
 *  hard
 */
public class Solution1840 {

    /**
     * beats 100%
     */
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int maxHeight = 0;
        int m = restrictions.length;
        int prevId = 1, prevHeight = 0;
        for (int i = 0; i < m; i++) {
            int currId = restrictions[i][0];
            int difference = currId - prevId;
            restrictions[i][1] = Math.min(restrictions[i][1], prevHeight + difference);
            prevId = currId;
            prevHeight = restrictions[i][1];
        }
        for (int i = m - 2; i >= 0; i--) {
            int difference = restrictions[i + 1][0] - restrictions[i][0];
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i + 1][1] + difference);
        }
        prevId = 1;
        prevHeight = 0;
        for (int i = 0; i < m; i++) {
            int currId = restrictions[i][0], currHeight = restrictions[i][1];
            int currMaxHeight = (currId - prevId + currHeight + prevHeight) / 2;
            maxHeight = Math.max(maxHeight, currMaxHeight);
            prevId = currId;
            prevHeight = currHeight;
        }
        int lastHeight = prevHeight + (n - prevId);
        maxHeight = Math.max(maxHeight, lastHeight);
        return maxHeight;
    }
}