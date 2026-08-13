package com.github.zhuo.algorithm.leetcode.problems.problems2201_2300;

/**
 * 由单个字符重复的最长子字符串
 */
public class Solution2213 {

    static class Segment {
        int maxLen;    // 区间最长
        int preLen;    // 前缀最长
        int sufLen;    // 后缀最长
        char preChar;  // 前缀字符
        char sufChar;  // 后缀字符
        int len;       // 区间长度

        public Segment() {
            maxLen = preLen = sufLen = len = 0;
            preChar = sufChar = 0;
        }
    }

    private Segment[] tree;
    private char[] arr;

    private void merge(Segment parent, Segment left, Segment right) {
        parent.len = left.len + right.len;
        parent.preChar = left.preChar;
        parent.sufChar = right.sufChar;

        // 合并前缀
        if (left.preLen == left.len && left.preChar == right.preChar) {
            parent.preLen = left.len + right.preLen;
        } else {
            parent.preLen = left.preLen;
        }

        // 合并后缀
        if (right.sufLen == right.len && right.sufChar == left.sufChar) {
            parent.sufLen = right.len + left.sufLen;
        } else {
            parent.sufLen = right.sufLen;
        }

        // 合并最大值
        parent.maxLen = Math.max(left.maxLen, right.maxLen);
        if (left.sufChar == right.preChar) {
            parent.maxLen = Math.max(parent.maxLen, left.sufLen + right.preLen);
        }
    }

    private void build(int node, int l, int r) {
        tree[node] = new Segment();
        if (l == r) {
            tree[node].maxLen = tree[node].preLen = tree[node].sufLen = 1;
            tree[node].preChar = tree[node].sufChar = arr[l];
            tree[node].len = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);
        merge(tree[node], tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(int node, int l, int r, int idx, char c) {
        if (l == r) {
            tree[node].preChar = c;
            tree[node].sufChar = c;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            update(node * 2, l, mid, idx, c);
        } else {
            update(node * 2 + 1, mid + 1, r, idx, c);
        }
        merge(tree[node], tree[node * 2], tree[node * 2 + 1]);
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        arr = s.toCharArray();
        int n = arr.length;
        tree = new Segment[4 * n];
        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];
        char[] chars = queryCharacters.toCharArray();

        for (int i = 0; i < k; i++) {
            update(1, 0, n - 1, queryIndices[i], chars[i]);
            ans[i] = tree[1].maxLen;
        }
        return ans;
    }
}