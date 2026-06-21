package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

/**
 * 雪糕的最大数量
 */
public class Solution1833 {

    /**
     * beats 99.23%
     */
    public int maxIceCream(int[] costs, int coins) {
        int ans = 0;
        int n = -1;
        for(int i : costs){
            n = Math.max(n,i);
        }
        int[] cnts = new int[n+1];  // 记录单价为i的雪糕的数量
        for(int i : costs){
            cnts[i]++;
        }
        for(int i = 1; i <= n; i++ ){ // 遍历1块钱到n块钱de雪糕
            int num = cnts[i];
            if(num == 0) continue;
            if(num * i <= coins){  // 手里的钱可以买完全部的单价为i的雪糕
                ans += num;
                coins -= num * i;
            }else if(num * i > coins && coins >= i){ // 对于单价为i的雪糕，全买完钱不够，但至少可以买一个
                ans += coins/i;
                coins -= (coins/i) * i;
            }else{  // 对于单价为i的雪糕，俺一块也买不起
                break;
            }
        }

        return ans;
    }
}
