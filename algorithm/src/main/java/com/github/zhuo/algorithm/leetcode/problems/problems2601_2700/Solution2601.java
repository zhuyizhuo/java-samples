package com.github.zhuo.algorithm.leetcode.problems.problems2601_2700;

public class Solution2601 {
    private final static int MX = 1000;
    private final static int[] primes = new int[169];

    static {
        boolean[] np = new boolean[MX + 1];
        int pi = 1; // primes[0] = 0 避免二分越界
        for (int i = 2; i <= MX; ++i)
            if (!np[i]) {
                primes[pi++] = i; // 预处理质数列表
                for (int j = i; j <= MX / i; ++j)
                    np[i * j] = true;
            }
    }

    public boolean primeSubOperation(int[] nums) {
        int pre = 0;
        for (int x : nums) {
            if (x <= pre) return false;
            int j = lowerBound(primes, x - pre);
            pre = x - primes[j - 1];
        }
        return true;
    }

    private int lowerBound(int[] nums, int target) {
        int left = -1, right = nums.length; // 开区间 (left, right)
        while (left + 1 < right) { // 区间不为空
            int mid = left + (right - left) / 2;
            if (nums[mid] < target)
                left = mid; // 范围缩小到 (mid, right)
            else
                right = mid; // 范围缩小到 (left, mid)
        }
        return right;
    }
}

/**
 * beats 100%
 */
class Solution {
    private static final int mx = 1000;
    private static final int[] primes = new int[169];
    static {
        boolean[] np = new boolean[mx + 1];
        int pi = 1;
        for (int i = 2; i <= mx; i++) {
            if (!np[i]) {
                primes[pi++] = i;
                for (int j = i; j <= mx / i; j++) {
                    np[i * j] = true;
                }
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        int pre = 0;
        for (int x : nums) {
            if (x <= pre) {
                return false;
            }
            int j = binarySearch(primes, x - pre);
            pre = x - primes[j - 1];
        }
        return true;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + r >>> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}