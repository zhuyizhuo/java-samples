package com.github.zhuo.algorithm.leetcode.problems.problems2001_2100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个下标从 0 开始的二维整数数组 events ，其中 events[i] = [startTimei, endTimei, valuei] 。
 * 第 i 个活动开始于 startTimei ，结束于 endTimei ，如果你参加这个活动，那么你可以得到价值 valuei 。
 * 你 最多 可以参加 两个时间不重叠 活动，使得它们的价值之和 最大 。
 *
 * 请你返回价值之和的 最大值 。
 *
 * 注意，活动的开始时间和结束时间是 包括 在活动时间内的，也就是说，你不能参加两个活动且它们之一的开始时间等于另一个活动的结束时间。
 * 更具体的，如果你参加一个活动，且结束时间为 t ，那么下一个活动必须在 t + 1 或之后的时间开始。
 *
 * 提示：
 *
 * 2 <= events.length <= 10^5
 * events[i].length == 3
 * 1 <= startTimei <= endTimei <= 10^9
 * 1 <= valuei <= 10^6
 */
public class Solution2054 {

    public int maxTwoEvents(int[][] events) {
        List<Event> evs = new ArrayList<>();
        for (int[] event : events) {
            evs.add(new Event(event[0], 0, event[2]));
            evs.add(new Event(event[1], 1, event[2]));
        }
        Collections.sort(evs);
        int ans = 0, bestFirst = 0;
        for (Event event : evs) {
            if (event.op == 0) {
                ans = Math.max(ans, event.val + bestFirst);
            } else {
                bestFirst = Math.max(bestFirst, event.val);
            }
        }
        return ans;
    }

    class Event implements Comparable<Event> {
        int ts;
        int op;
        int val;

        Event(int ts, int op, int val) {
            this.ts = ts;
            this.op = op;
            this.val = val;
        }

        @Override
        public int compareTo(Event other) {
            if (this.ts != other.ts) {
                return Integer.compare(this.ts, other.ts);
            }
            return Integer.compare(this.op, other.op);
        }
    }

}

/**
 * beats 100%
 */
class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a, b)->a[0]-b[0]);
        int n = events.length;
        int[] f = new int[n+1];
        for(int i = n-1; i >= 0; i--){
            f[i] = Math.max(f[i+1],events[i][2]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int v = events[i][2];
            int en = events[i][1];
            int L = i,R = n;
            while(L + 1 < R){
                int mid = L + ((R-L)>>1);
                if(events[mid][0] <= en){
                    L = mid;
                }else{
                    R = mid;
                }
            }
            if(R != n){
                v += f[R];
            }
            ans = Math.max(ans,v);
        }
        return ans;
    }
}