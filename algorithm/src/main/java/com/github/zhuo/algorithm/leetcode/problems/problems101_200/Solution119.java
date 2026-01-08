package com.github.zhuo.algorithm.leetcode.problems.problems101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/pascals-triangle-ii/
 * 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class Solution119 {

    public static void main(String[] args) {
        System.out.println(getRow(4));
    }

    /**
     * 此处的定义是从第0行开始
     * 即第0行1个元素  第1行2个元素 以此类推
     *
     * 执行用时: 2 ms  beats 35.3%
     * 内存消耗: 36.5 MB  beats 100%
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        int line = 0;
        List<Integer> resp = new ArrayList<>(l);
        //循环求每行
        while (line < rowIndex){
            resp = new ArrayList<>();
            //循环求每行的每个元素
            for (int i = 0; i <= line; i++) {
                //开始和结束都直接追加
                if (i == 0){
                    resp.add(l.get(i));
                } else if (i > 0){
                    Integer integer = l.get(i);
                    Integer integer1 = l.get(i - 1);
                    resp.add(integer + integer1);
                }
                if (i == l.size() - 1){
                    resp.add(l.get(i));
                }
            }
            l = resp;
            line++;
        }
        return resp;
    }

    /**
     * 0ms
     * beats 100%
     */
    public List<Integer> getRow1(int rowIndex) {

        List<Integer> res = new ArrayList<Integer>();

        long nk = 1;

        for (int i = 0; i <= rowIndex; i++) {

            res.add((int)nk);

            nk = nk * (rowIndex - i) / (i + 1);
        }

        return res;
    }
}
