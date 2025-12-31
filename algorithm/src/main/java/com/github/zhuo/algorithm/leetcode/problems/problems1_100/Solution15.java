package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * https://leetcode.com/problems/3sum/
 *
 * 三数之和
 * 难度 中等
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 */
public class Solution15 {

    public static void main(String[] args) {
        //排序后为  -4 -1 -1 0 1 2
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
//        System.out.println(threeSum(new int[]{0,0,0,0}));
//        System.out.println(threeSum(new int[]{3,0,-2,-1,1,2}));
    }

    /**
     * 本题难点在于 如何去重
     *
     * 我们先把数组排序
     *
     * 执行用时： 1672 ms , 在所有 Java 提交中击败了 5.00% 的用户
     * 内存消耗： 42.4 MB , 在所有 Java 提交中击败了 60.93% 的用户
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (length < 3){
            return new ArrayList<>();
        }
        //对数组排序
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            //因为数组有序 如果第一个值大于0 后续所有值都为正数 和不可能为0
            if (nums[i] > 0){
                return list;
            }
            //去重  如果和上一个数相等 直接跳过
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            //第二个数
            for (int j = i + 1; j < length; j++) {
                //去重  如果和上一个数相等 直接跳过
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                //第三个数
                for (int k = length - 1; k > j; k--) {
                    if (nums[j] + nums[k] < target){
                        //因为数组是有序的 如果后两数的和小于目标值，继续循环只会让第三个数继续变小，所以可直接跳出循环
                        break;
                    }
                    if (nums[j] + nums[k] == target){
                        inner.add(nums[i]);
                        inner.add(nums[j]);
                        inner.add(nums[k]);
                        list.add(inner);
                        inner = new ArrayList<>();
                        //只要找到一个满足条件的 就可以跳出本层循环
                        break;
                    }
                }
            }
        }
        return list;
    }

    /**
     * 在题解基础上优化
     *
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if (length < 3){
            return list;
        }
        //对数组排序
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            //因为数组有序 如果第一个值大于0 后续所有值都为正数 和不可能为0
            if (nums[i] > 0){
                return list;
            }
            //去重  如果和上一个数相等 直接跳过
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            //第二个数
            for (int j = i + 1; j < length; j++) {
                //去重  如果和上一个数相等 直接跳过
                if (j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                //第三个数
                for (int k = length - 1; k > j; k--) {
                    if (nums[j] + nums[k] < target){
                        //因为数组是有序的 如果后两数的和小于目标值，继续循环只会让第三个数继续变小，所以可直接跳出循环
                        break;
                    }
                    if (nums[j] + nums[k] == target){
                        List<Integer> inner = new ArrayList<>();
                        inner.add(nums[i]);
                        inner.add(nums[j]);
                        inner.add(nums[k]);
                        list.add(inner);
                        //只要找到一个满足条件的 就可以跳出本层循环
                        break;
                    }
                }
            }
        }
        return list;
    }

}
