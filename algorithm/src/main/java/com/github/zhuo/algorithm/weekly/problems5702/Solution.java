package com.github.zhuo.algorithm.weekly.problems5702;

/**
 * 找出星型图的中心节点 显示英文描述
 * 题目难度Medium
 *
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 *
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{{1,2},{2,3},{2,4}}));
        System.out.println(findCenter(new int[][]{{1,2},{5,1},{1,3},{1,4}}));
    }

    public static int findCenter(int[][] edges) {
        int length = edges.length;
        int lastLeft = -1;
        int lastRight = -1;
        for (int i = 0; i < length; i++) {
            if (edges[i][0] == lastLeft || edges[i][0] == lastRight){
                return edges[i][0];
            }
            if (edges[i][1] == lastLeft || edges[i][1] == lastRight){
                return edges[i][1];
            }
            lastLeft = edges[i][0];
            lastRight = edges[i][1];
        }
        return -1;
    }
}
