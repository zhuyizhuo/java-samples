package com.github.zhuo.algorithm.leetcode.problems.problems1101_1200;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
 *
 * 等价多米诺骨牌对的数量
 * 
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 *
 */
public class Solution1128 {

    public static void main(String[] args) {
        //TODO 待改进更优解
        System.out.println(numEquivDominoPairs(new int[][]{{1,2},{2,1},{3,4},{4,3},{3,4},{5,6}}));
    }

    /**
     * 思路：
     * 分析题意可将该题转为如下表述:
     * 1. 找出给出数组中所有相同或反转后相同的牌的张数。
     * 2. 给你 x 张牌, 两两匹配组合 共有多少种组合?
     *
     * 重复出现次数   组合数
     * 1               1
     * 2               3 = 2+1
     * 3               6 = 3+2+1
     * 4              10 = 4+3+2+1
     *
     * 可用等差数列求和公式算出组合数。
     */
    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] dominoe = dominoes[i];
            String key = dominoe[0] + "_" + dominoe[1];
            String reKey = dominoe[1] + "_" + dominoe[0];
            Integer dominoe0 = m.get(key);
            Integer dominoe1 = m.get(reKey);
            //统计重复出现次数
            if (dominoe0 != null || dominoe1 != null){
                Integer integer = dominoe0 != null ? dominoe0 : dominoe1;
                m.put(key, integer + 1);
            } else {
                m.put(key, 0);
            }
            if (!key.equals(reKey)){
                m.remove(reKey);
            }
        }
        int count = 0;
        //根据重复出现次数计算总数
        for (Map.Entry<String, Integer> s: m.entrySet()) {
            Integer value = s.getValue();
            for (int i = 1; i <= value; i++) {
                count += i;
            }
        }
        return count;
    }
}
