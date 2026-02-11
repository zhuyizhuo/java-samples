package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长平衡子数组 II
 * hard
 * 给你一个整数数组 nums。
 *
 * 如果子数组中 不同偶数 的数量等于 不同奇数 的数量，则称该 子数组 是 平衡的 。
 *
 * 返回 最长 平衡子数组的长度。
 *
 * 子数组 是数组中连续且 非空 的一段元素序列。
 */
public class Solution3721 {
    // *************** 下面是模版 ***************
    class Node {
        Node left, right;
        int max, min, add;
    }
    private int n = (int) 1e9;
    private Node root = new Node();
    //在[start, end]范围，更新[l,r]区间的值为val,惰性覆盖更新
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.max += val;
            node.min += val;
            node.add += val;
            return;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }
    //在[start, end]范围，查询[l,r]区间的值的第一次出现位置
    public int queryFirst(Node node, int start, int end, int l, int r, int target) {
        if (start > r || end < l || node.max < target || node.min > target) return -1;
        if (start == end) return start;
        pushDown(node);
        int mid = (start + end) >> 1;
        int ans =  queryFirst(node.left, start, mid, l, r, target);
        if (ans < 0) ans = queryFirst(node.right, mid + 1, end, l, r,  target);
        return ans;
    }
    private void pushUp(Node node) {
        node.max = Math.max(node.left.max, node.right.max);
        node.min = Math.min(node.left.min, node.right.min);
    }
    private void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return ;
        node.left.max += node.add;
        node.left.min += node.add;
        node.right.max += node.add;
        node.right.min += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }

    /**
     * beats 94%
     */
    public int longestBalanced(int[] nums) {
        n = nums.length;
        Map<Integer, Integer> valLastPosMap = new HashMap<>(); //数字最后一次出现的位置
        int ans = 0;
        int delta = 0;
        for(int i = 1; i <= n; i++){
            int x = nums[i - 1];
            int val = (x%2 == 0) ? 1 : -1;
            //首次出现，[i,n] 要全部增加val
            if(!valLastPosMap.containsKey(x)){
                update(root, 1, n, i, n, val);
                delta += val;
            }
            //再次遇到，撤销[j,i)的增加
            else{
                int j = valLastPosMap.get(x);
                if(i-1 >= j) update(root, 1, n, j, i - 1, -val);
            }
            valLastPosMap.put(x, i);
            //把i-1优化成i-1-ans, 在更大的下标搜索不会得到更优的解
            if(delta == 0) ans = i;
            else if(i-ans >= 1) {
                int ll = queryFirst(root, 1, n, 1, i - ans, delta);
                if (ll >= 0) ans = Math.max(ans, i - ll);
            }
        }
        return ans;
    }
}