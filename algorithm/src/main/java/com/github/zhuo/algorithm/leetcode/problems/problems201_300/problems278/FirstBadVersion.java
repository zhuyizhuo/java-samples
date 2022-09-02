package com.github.zhuo.algorithm.leetcode.problems.problems201_300.problems278;

/**
 *
 * https://leetcode.cn/problems/first-bad-version/
 *
 * 第一个错误的版本
 *
 * 难度 简单
 *
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 该题暴力解会超时
 *
 * 1 <= bad <= n <= 2^31 - 1
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        //2126753390  1702766719
        // 5  4
        // 1  1
        System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int start = 1;
        int last = n;
        while (start <= last){
            int middle = start + (last - start)/2;
            boolean r = isBadVersion(middle);
            if (r){
                last = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }

    private static boolean isBadVersion(int i) {
        return i >= 4;
    }
}
