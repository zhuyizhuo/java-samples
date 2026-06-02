package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 最早完成陆地和水上游乐设施的时间 I
 *
 * 给你两种类别的游乐园项目：陆地游乐设施 和 水上游乐设施。
 *
 * 陆地游乐设施
 * landStartTime[i] – 第 i 个陆地游乐设施最早可以开始的时间。
 * landDuration[i] – 第 i 个陆地游乐设施持续的时间。
 * 水上游乐设施
 * waterStartTime[j] – 第 j 个水上游乐设施最早可以开始的时间。
 * waterDuration[j] – 第 j 个水上游乐设施持续的时间。
 * 一位游客必须从 每个 类别中体验 恰好一个 游乐设施，顺序 不限 。
 *
 * 游乐设施可以在其开放时间开始，或 之后任意时间 开始。
 * 如果一个游乐设施在时间 t 开始，它将在时间 t + duration 结束。
 * 完成一个游乐设施后，游客可以立即乘坐另一个（如果它已经开放），或者等待它开放。
 * 返回游客完成这两个游乐设施的 最早可能时间 。
 */
public class Solution3633 {
    /**
     * beats 100%
     */
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int minEnd = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(landStartTime[i]+landDuration[i]<minEnd){
                minEnd = landStartTime[i]+landDuration[i];
            }
        }
        int minEnd2 = Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            int s = Math.max(minEnd,waterStartTime[i]);
            if(s+waterDuration[i]<minEnd2){
                minEnd2 = s+waterDuration[i];
            }
        }
        int minEnd3 = Integer.MAX_VALUE;
        for(int i=0;i<waterStartTime.length;i++){
            if(waterStartTime[i]+waterDuration[i]<minEnd3){
                minEnd3 = waterStartTime[i]+waterDuration[i];
            }
        }
        int minEnd4 = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int s = Math.max(minEnd3,landStartTime[i]);
            if(s+landDuration[i]<minEnd4){
                minEnd4 = s+landDuration[i];
            }
        }
        return Math.min(minEnd2,minEnd4);

    }
}
