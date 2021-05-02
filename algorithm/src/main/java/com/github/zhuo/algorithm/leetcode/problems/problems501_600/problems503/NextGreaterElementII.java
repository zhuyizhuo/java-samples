package com.github.zhuo.algorithm.leetcode.problems.problems501_600.problems503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/next-greater-element-ii/
 * 下一个更大元素 II
 * 难度 中等
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。
 * 如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 *
 */
public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] x = {1, 2, 1};
        int[] ints = nextGreaterElements(x);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 思路
     * 本题如果暴力求解，对于每个元素都向后去寻找比它更大的元素，那么时间复杂度 O(N^2) 会超时。必须想办法优化。
     *
     * 我们注意到，暴力解法中，如果数组的前半部分是单调不增的，
     * 那么会有很大的计算资源的浪费。比如说 [6,5,4,3,8]，对于前面的 [6,5,4,3] 等数字都需要向后遍历，
     * 当寻找到元素 8 时才找到了比自己大的元素；而如果已知元素 6 向后找到元素 8 才找到了比自己的大的数字，
     * 那么对于元素 [5,4,3] 来说，它们都比元素 6 更小，所以比它们更大的元素一定是元素 8，
     * 不需要单独遍历对 [5,4,3] 向后遍历一次！
     *
     * 根据上面的分析可知，可以遍历一次数组，如果元素是单调递减的（则他们的「下一个更大元素」相同），
     * 我们就把这些元素保存，直到找到一个较大的元素；把该较大元素逐一跟保存了的元素比较，如果该元素更大，那么它就是前面元素的「下一个更大元素」。
     *
     * 在实现上，我们可以使用「单调栈」来实现，单调栈是说栈里面的元素从栈底到栈顶是单调递增或者单调递减的。
     *
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 85.75% 的用户
     * 内存消耗： 40.5 MB , 在所有 Java 提交中击败了 25.70% 的用户
     */
    public static int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] resp = new int[length];
        Arrays.fill(resp, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i%length]){
                resp[stack.pop()] = nums[i%length];
            }
            stack.push(i%length);
        }
        return resp;
    }

}
