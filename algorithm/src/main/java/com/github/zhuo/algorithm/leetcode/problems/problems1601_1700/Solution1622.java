package com.github.zhuo.algorithm.leetcode.problems.problems1601_1700;

import java.util.ArrayList;
import java.util.List;

/**
 * 奇妙序列
 * hard
 *
 * 请你实现三个 API append，addAll 和 multAll 来实现奇妙序列。
 *
 * 请实现 Fancy 类 ：
 *
 * Fancy() 初始化一个空序列对象。
 * void append(val) 将整数 val 添加在序列末尾。
 * void addAll(inc) 将所有序列中的现有数值都增加 inc 。
 * void multAll(m) 将序列中的所有现有数值都乘以整数 m 。
 * int getIndex(idx) 得到下标为 idx 处的数值（下标从 0 开始），并将结果对 109 + 7 取余。如果下标大于等于序列的长度，请返回 -1 。
 */
public class Solution1622 {
}

/**
 * beats 98.28%
 */
class Fancy {
    List<long[]> factors = new ArrayList<>();
    List<Integer> values = new ArrayList<>();

    public Fancy() {
        factors.add(new long[]{0, 0});
    }

    public void append(int val) {
        values.add(val);
        factors.add(new long[]{1, 0});
    }

    public void addAll(int inc) {
        int i = factors.size() - 1;
        while (i > 0) {
            long[] factor = factors.get(i);
            factor[1] += inc;
            i -= (i & -i);
        }
    }

    public void multAll(int m) {
        int i = factors.size() - 1;
        while (i > 0) {
            long[] factor = factors.get(i);
            factor[0] = (factor[0] * m) % 1000_000_007L;
            factor[1] = factor[1] * m  % 1000_000_007L;
            i -= (i & -i);
        }
    }

    public int getIndex(int idx) {
        if (idx >= values.size()) {
            return -1;
        }
        // 依次获取所有上层操作，最后就是当前下标的值
        long val = values.get(idx);
        idx++;
        while (idx < factors.size()) {
            long[] factor = factors.get(idx);
            val = (val * factor[0] + factor[1]) % 1000_000_007L;
            idx += (idx & -idx);
        }
        return (int) val;
    }
}
