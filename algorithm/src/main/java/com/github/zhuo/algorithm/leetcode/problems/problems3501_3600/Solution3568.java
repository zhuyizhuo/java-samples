package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

/**
 * 清理教室的最少移动
 */
public class Solution3568 {

    /**
     * beats 100%
     */
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        char[][] g = new char[m][];
        for (int i = 0; i < m; i++) g[i] = classroom[i].toCharArray();
        int[] litter = new int[10];
        int cntL = 0, start = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 'L') litter[cntL++] = i * n + j;
                else if (g[i][j] == 'S') start = i * n + j;
            }
        }
        int[] bit = new int[m * n];
        java.util.Arrays.fill(bit, -1);
        for (int i = 0; i < cntL; i++) bit[litter[i]] = i;
        int full = (1 << cntL) - 1;
        if (cntL == 0) return 0;

        int cells = m * n, masks = 1 << cntL;
        int[] best = new int[cells * masks];
        java.util.Arrays.fill(best, -1);
        best[start * masks] = energy;
        java.util.ArrayDeque<int[]> q = new java.util.ArrayDeque<>();
        q.add(new int[]{start, 0, energy});
        int moves = 0;
        int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            int sz = q.size();
            moves++;
            for (int s = 0; s < sz; s++) {
                int[] st = q.poll();
                int id = st[0], mask = st[1], e = st[2];
                if (e == 0) continue;
                int r = id / n, c = id % n;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k], nc = c + dc[k];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                    char ch = g[nr][nc];
                    if (ch == 'X') continue;
                    int ne = e - 1;
                    if (ch == 'R') ne = energy;
                    int nid = nr * n + nc;
                    int nmask = mask;
                    if (bit[nid] >= 0) nmask |= 1 << bit[nid];
                    if (nmask == full) return moves;
                    int key = nid * masks + nmask;
                    if (best[key] >= ne) continue;
                    best[key] = ne;
                    q.add(new int[]{nid, nmask, ne});
                }
            }
        }
        return -1;
    }
}