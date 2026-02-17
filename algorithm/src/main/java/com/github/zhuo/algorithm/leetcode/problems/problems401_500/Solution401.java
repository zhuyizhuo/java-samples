package com.github.zhuo.algorithm.leetcode.problems.problems401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表
 * easy
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 * 例如，下面的二进制手表读取 "4:51" 。
 *
 *
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 *
 * 小时不会以零开头：
 *
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 *
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 */
public class Solution401 {

    static List<String>[] memo = new List[11];

    /**
     * beats 99.14%
     */
    public List<String> readBinaryWatch(int turnedOn) {
        if(memo[0] == null){
            for(int i = 0; i < memo.length; ++i)
                memo[i] = new ArrayList<String>();

            for(int hour = 0; hour < 12; ++hour){
                int count1 = Integer.bitCount(hour);
                StringBuilder builder = new StringBuilder();
                builder.append(hour).append(':');
                int len = builder.length();
                for(int minute = 0; minute < 60; ++minute){
                    int count2 = Integer.bitCount(minute);

                    builder.append(minute / 10).append(minute % 10);
                    memo[count1 + count2].add(builder.toString());
                    builder.setLength(len);
                }
            }
        }

        return memo[turnedOn];
    }
}
