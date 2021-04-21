package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems33;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 搜索旋转排序数组
 * 难度 中等
 * 
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1。
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 *
 * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        //todo 需优化时间复杂度
    }

    /**
     * 直接搜
     * 执行用时: 0 ms
     * 内存消耗: 37.9 MB
     * O(n) 复杂度
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