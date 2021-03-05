package com.github.zhuo.algorithm.leetcode.problems354;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 俄罗斯套娃信封问题
 * 难度 困难
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，
 * 这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 */
public class RussianDollEnvelopes {

    public static void main(String[] args) {
        // [[4,5],[4,6],[6,7],[2,3],[1,1],[1,1]]  预期 4
        System.out.println(maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1},{1,1}}));
        //[[30,50],[12,2],[3,4],[12,15]]  预期 3
        System.out.println(maxEnvelopes(new int[][]{{30,50},{12,2},{3,4},{12,15}}));
    }

    /**
     * 思路 先对宽度进行排序，同样宽度的只保留最小的高度
     * 依次比对高度，高度大于上一个信封的高度则信封数+1
     * 反例：
     * [[30,50],[12,2],[3,4],[12,15]]  预期 3
     * 改进：
     * 同样宽度的保留所有高度，因为宽度已经有序，所以问题退化为 在给定的数字序列中，求最大的升序子序列
     * 使用滑动窗口判定
     */
    public static int maxEnvelopes(int[][] envelopes) {
        TreeMap<Integer,Integer> treeMap = new TreeMap();
        int length = envelopes.length;
        for (int i = 0; i < length; i++) {
            int[] envelope = envelopes[i];
            Integer o = treeMap.get(envelope[0]);
            if (o != null){
                treeMap.put(envelope[0], Math.min(o, envelope[1]));
            } else {
                treeMap.put(envelope[0], envelope[1]);
            }
        }
        int count = 0;
        Integer lastVal = null;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : treeMap.entrySet()) {
            Integer value = integerIntegerEntry.getValue();
            if (lastVal == null){
                lastVal = value;
                count++;
            } else if (lastVal < value){
                count++;
            }
        }
        return count;
    }

}
