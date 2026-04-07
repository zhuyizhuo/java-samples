package com.github.zhuo.algorithm.leetcode.problems.problems2001_2100;


/**
 * 模拟行走机器人 II
 *
 * 给你一个在 XY 平面上的 width x height 的网格图，左下角 的格子为 (0, 0) ，右上角 的格子为 (width - 1, height - 1) 。网格图中相邻格子为四个基本方向之一（"North"，"East"，"South" 和 "West"）。一个机器人 初始 在格子 (0, 0) ，方向为 "East" 。
 *
 * 机器人可以根据指令移动指定的 步数 。每一步，它可以执行以下操作。
 *
 * 沿着当前方向尝试 往前一步 。
 * 如果机器人下一步将到达的格子 超出了边界 ，机器人会 逆时针 转 90 度，然后再尝试往前一步。
 * 如果机器人完成了指令要求的移动步数，它将停止移动并等待下一个指令。
 *
 * 请你实现 Robot 类：
 *
 * Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝 "East" 。
 * void step(int num) 给机器人下达前进 num 步的指令。
 * int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。
 * String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。
 */
public class Solution2069 {
}

/**
 * beats 93.61%
 */
class Robot {

    //int[] ans = { 0, 0 };
    int x = 0;
    int y = 0;
    int dir = 1;
    int width;
    int height;
    String[] dirs = { "North", "East", "South", "West" };
    int perimeter; // 一圈总长  机器人只会在网格边上循环走

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height - 2);
    }

    public void step(int num) {
        if (num == 0) {
            return;
        }
        num = (num - 1) % perimeter;
        step1(num);
        step1(1);
    }

    public void step1(int num) {
        while (true) {
            switch (dir) {
                case 0: {
                    if (y + num < height) {
                        y += num;
                        return;
                    }
                    num -= (height - 1 - y);
                    y = height - 1;
                    dir = 3;
                    break;
                }
                case 1: {
                    if (x + num < width) {
                        x += num;
                        return;
                    }
                    num -= (width - 1 - x);
                    x = width - 1;
                    dir = 0;
                    break;
                }
                case 2: {
                    if (y >= num) {
                        y -= num;
                        return;
                    }
                    num -= y;
                    y = 0;
                    dir = 1;
                    break;
                }
                case 3: {
                    if (x >= num) {
                        x -= num;
                        return;
                    }
                    num -= x;
                    x = 0;
                    dir = 2;
                    break;
                }
            }
        }
    }

    public int[] getPos() {
        return new int[] { x, y };
    }

    public String getDir() {
        return dirs[dir];
    }
}
