package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * 平方根
 */
public class Solution69 {

    public static void main(String[] args) {
        System.out.println(mySolution69(4));
    }

    /**
     * 此类题型一定要考虑丢失精度的问题
     */
    public static int mySolution69(int x) {
        int left = 0;
        int right = x;
        while (left <= right){
            int middle = (left + right)/2;
            long i1 = (long)middle * middle;
            if (i1 < 0){
                right = middle - 1;
                continue;
            }
            if (i1 == x){
                return middle;
            } else if (i1 > x){
                int plusOne = middle - 1;
                long i = (long)plusOne * plusOne;
                if (i == x){
                    return plusOne;
                } else if (i < x){
                    return plusOne;
                }
                right = middle - 1;
                continue;
            } else if (i1 < x){
                //如果中间数的平方小于给定X,则加一尝试
                int addOne = middle + 1;
                long i = (long)addOne * addOne;
                if (i == x){
                    return addOne;
                } else if (i > x){
                    return middle;
                }
                left = middle + 1;
                continue;
            }
        }
        return -1;
    }

    class Solution {
        /**
         * beats 97.44%
         */
        public int mySolution69(int x) {
            int left = 1;
            int right = x;
            int result = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid > x / mid) {
                    right = mid - 1;
                } else {
                    result = mid;
                    left = mid + 1;
                }
            }
            return result;
        }
    }

}
