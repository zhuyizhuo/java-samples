package com.github.zhuo.algorithm.lintcode.problem2;

/**
 * https://www.lintcode.com/problem/trailing-zeros/description
 *
 * 设计一个算法，计算出n阶乘中尾部零的个数
 *
 * 样例
 * 样例  1:
 * 	输入: 11
 * 	输出: 2
 *
 * 	样例解释:
 * 	11! = 39916800, 结尾的0有2个。
 *
 * 样例 2:
 * 	输入:  5
 * 	输出: 1
 *
 * 	样例解释:
 * 	5! = 120， 结尾的0有1个。
 *
 * 挑战
 * O(logN)的时间复杂度
 */
public class TrailingZeros {

    /**
     * 分析题目  尾数0的个数 可以 理解为阶乘的过程中  有多少个10出现 因为 任何数*10就是尾部增加一个0
     *
     * 而10 = 2*5 其中5又比2的出现次数更少，所以应该计算阶乘中存在多少个因子 5
     *  乘法交换律举例
     *  10! =  1*2*3*4*5*6*7*8*9*10 = (2*5*2*5) * (3*2*6*7*8*9*2) = (3*2*6*7*8*9*2) * 100  所以尾部有2个0
     *  上述示例将 4=2*2  10=2*5 拆分出来两组 2*5 所以可得末尾2个0
     *  因为2非常好拆分出来，所以我们只用计算阶乘中5有多少个即可  需注意 25 75 等数字可以分解出多个因子5
     */
    public static void main(String[] args) {
        System.out.println(trailingZeros(5555550000000L));
    }

    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public static long trailingZeros(long n) {
        if(n < 0){
            return 0;
        }
        long count = 0;
        while (n > 0){
            n /= 5L;
            count += n;
        }
        return count;
    }
}
