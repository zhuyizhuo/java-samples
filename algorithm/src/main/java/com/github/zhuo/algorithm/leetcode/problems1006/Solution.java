package com.github.zhuo.algorithm.leetcode.problems1006;

public class Solution {

    /**
     * 公式推导法 总结规律
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.2 MB , 在所有 Java 提交中击败了 64.52% 的用户
     */
    public int clumsy(int N) {
        if (N == 1){
            return 1;
        } else if (N == 2){
            return 2;
        } else if (N == 3){
            return 6;
        } else if (N == 4){
            return 7;
        }
        if (N % 4 == 0){
            return N + 1;
        } else if (N % 4 <= 2){
            return N + 2;
        } else {
            return N - 1;
        }
    }
}
