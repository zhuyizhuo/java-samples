package com.github.zhuo.algorithm.leetcode.problems33;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        //todo 需优化时间复杂度
    }

    /**
     * O(n) 复杂度
     * 需尝试优化为 O(log n)
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
