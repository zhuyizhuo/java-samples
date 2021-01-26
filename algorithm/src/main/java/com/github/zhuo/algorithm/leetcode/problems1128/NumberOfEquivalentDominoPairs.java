package com.github.zhuo.algorithm.leetcode.problems1128;

import java.util.HashMap;
import java.util.Map;

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
public class NumberOfEquivalentDominoPairs {

    public static void main(String[] args) {
        //TODO
        System.out.println(numEquivDominoPairs(new int[][]{{1,2},{1,2},{1,1},{1,2},{2,1}}));
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> m = new HashMap<>();
        int count = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int[] dominoe = dominoes[i];
            String key = dominoe[0] + "_" + dominoe[1];
            String reKey = dominoe[1] + "_" + dominoe[0];
            Integer dominoe0 = m.get(key);
            Integer dominoe1 = m.get(reKey);
            if (dominoe0 != null || dominoe1 != null){
                m.put(key, 2 * dominoe0);

            } else {
//                m.put(dominoe[0], dominoe[1]);
//                m.put(dominoe[1], dominoe[0]);
            }
        }
        return count;
    }
}
