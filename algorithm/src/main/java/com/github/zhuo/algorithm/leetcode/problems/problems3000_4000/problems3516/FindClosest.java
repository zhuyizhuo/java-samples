package com.github.zhuo.algorithm.leetcode.problems.problems3000_4000.problems3516;


/**
 * @description:
 * @author: zhuo
 * @date: 2025-09-04 19:30
 */
public class FindClosest {

    public static void main(String[] args) {
        System.out.println(findClosest(2,7,4));
        System.out.println(findClosest(2,5,6));
        System.out.println(findClosest(1,5,3));
    }

    public static int findClosest(int x, int y, int z) {

        int xz = Math.abs(x - z);
        int yz = Math.abs(y - z);
        if (xz - yz > 0){
            return 2;
        } else if (xz - yz == 0){
            return 0;
        } else {
            return 1;
        }
    }
}
