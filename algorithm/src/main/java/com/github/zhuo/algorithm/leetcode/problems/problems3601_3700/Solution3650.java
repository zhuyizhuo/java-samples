package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 边反转的最小路径总成本
 * medium
 *
 * 给你一个包含 n 个节点的有向带权图，节点编号从 0 到 n - 1。同时给你一个数组 edges，其中 edges[i] = [ui, vi, wi] 表示一条从节点 ui 到节点 vi 的有向边，其成本为 wi。
 *
 * 每个节点 ui 都有一个 最多可使用一次 的开关：当你到达 ui 且尚未使用其开关时，你可以对其一条入边 vi → ui 激活开关，将该边反转为 ui → vi 并 立即 穿过它。
 *
 * 反转仅对那一次移动有效，使用反转边的成本为 2 * wi。
 *
 * 返回从节点 0 到达节点 n - 1 的 最小 总成本。如果无法到达，则返回 -1。
 *
 */
public class Solution3650 {
    int[]edge,next,weight,head;
    int index=0;
    void add(int u,int v ,int w){
        edge[index]=v;
        weight[index]=w;
        next[index]=head[u];
        head[u]=index++;
    }

    /**
     * beats 100%
     */
    public int minCost(int n, int[][] edges) {
        int m=edges.length;
        edge=new int[m<<1];
        weight=new int[m<<1];
        next=new int[m<<1];
        head=new int[n];
        Arrays.fill(head,-1);

        for(int []e:edges){
            int u=e[0];
            int v=e[1];
            int w=e[2];
            add(u,v,w);
            add(v,u,2*w);
        }
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        PriorityQueue<int[]> que=new PriorityQueue<>((a, b)->a[0]-b[0]);
        que.offer(new int[]{0,0});
        while(!que.isEmpty()){
            int p[]=que.poll();
            int x=p[1];
            int dx=p[0];
            if(dx>dis[x])continue;
            if(x==n-1)return dx;
            for(int index=head[x];index!=-1;index=next[index]){
                int y=edge[index];
                int newDis=dx+weight[index];
                if(newDis<dis[y]){{
                    dis[y]=newDis;
                    que.offer(new int[]{newDis,y});
                }}
            }

        }
        return -1;
    }
}