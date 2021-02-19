package com.github.zhuo.algorithm.leetcode.problems1004;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 *
 * 最大连续1的个数 III
 *
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 */
public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes1(a, 2));
        int[] a1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(longestOnes1(a1, 3));
    }

    /**
     * 思路：
     *  分析题意可知此题可使用滑动窗口方法来解题
     *
     * 先用暴力法解题:
     * 将下标依次从数组的左边向右边移动，并且统计当前长度与当前子数组中0的数量，直至0的数量大于K
     * 将下标向右移动一位，继续循环
     *
     * 执行用时： 1749 ms , 在所有 Java 提交中击败了 5.49% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 30.92% 的用户
     */
    public static int longestOnes(int[] A, int K) {
        int maxLength = 0;
        int currLength = 0;
        int zeroCount = 0;
        int start = 0;
        int index = 0;
        int length = A.length;
        while (start < length && index < length){
            if (A[index] == 0){
                zeroCount ++;
                // 如果可转换的0的数量大于K
                if (zeroCount > K){
                    maxLength = Math.max(currLength, maxLength);
                    zeroCount = 0;
                    currLength = 0;
                    start++;
                    index=start;
                    continue;
                }
            }
            index++;
            currLength ++;
        }
        return Math.max(currLength, maxLength);
    }

    /**
     * 在暴力法基础上优化为滑动窗口：
     * 分析题意可知：如果当前子数组的0数量超过K时，仅需将整体向右滑动，不需重新计算当前的长度，移出左侧为0的元素
     *  1. 在当前的子数组0数量超过K的时候，如果最左边是0，可直接将当前0的数量-1, 并将起始下标+1, 继续向右拓展
     *  2. 在当前的子数组0数量超过K的时候，如果最左边非0，则循环下标直至找到第一个为0下标, 每次循环当前长度减1,
     *      找到第一个为0下标后，将当前0的数量-1， 并将起始下标+1, 继续向右拓展，记得判断边界值
     *  3. 如果从起始下标至最后元素总长度小于最大长度，也可以直接终止循环
     *
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 94.07% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 24.00% 的用户
     */
    public static int longestOnes1(int[] A, int K) {
        int maxLength = 0;
        int currLength = 0;
        int zeroCount = 0;
        int start = 0;
        int index = 0;
        int length = A.length;
        while (start < length && index < length){
            if (A[index] == 0){
                zeroCount ++;
                // 如果可转换的0的数量大于K
                if (zeroCount > K){
                    maxLength = Math.max(currLength, maxLength);
                    while (A[start] != 0){
                        start++;
                        currLength--;
                    }
                    //最左边元素为0 将开始指针和结束指针向右移动一位
                    start++;
                    //如果总长度减去开始下标 小于等于最大长度 直接退出循环
                    if (length - start <= maxLength){
                        break;
                    }
                    index++;
                    zeroCount--;
                    if (index <= start){
                        index = start;
                        zeroCount = 0;
                        currLength = 0;
                    }
                    continue;
                }
            }
            index++;
            currLength ++;
        }
        return Math.max(currLength, maxLength);
    }

    /**
     * 此题的一个很妙的解法
     *
     * 思路:
     *  因为题解要求最长子数组长度，所以我们仅维护最大窗口，如果不满足就继续右移，直至退出循环，
     *  返回右侧下标减去左侧下标 即为最长子数组长度
     *
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.8 MB , 在所有 Java 提交中击败了 45.80% 的用户
     */
    public int longestOnes2(int[] A, int K) {
        //窗口左边的位置
        int left = 0;
        //窗口右边的位置
        int right = 0;
        //窗口中0的个数
        int zeroCount = 0;
        while (right < A.length) {
            zeroCount += 1 - A[right];
            if (zeroCount > K){
                //如果0的个数超出限度，则将窗口左侧右移一个位置，因为右侧每次都右移，所以一直保持最大的窗口长度
                zeroCount -= 1 - A[left++];
            }
            right++;
        }
        //因为结束循环时 right 等于 A.length 所以不用再+1
        return right - left;
    }
}
