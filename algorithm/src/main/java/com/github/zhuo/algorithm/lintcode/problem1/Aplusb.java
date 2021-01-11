package com.github.zhuo.algorithm.lintcode.problem1;

/**
 * https://www.lintcode.com/problem/a-b-problem/description
 *
 * 1. A + B 问题
 * 给出两个整数 aa 和 bb , 求他们的和。
 *
 * 样例
 * 样例 1:
 * 输入:  a = 1, b = 2
 * 输出: 3
 * 样例解释: 返回a+b的结果.
 *
 * 样例 2:
 * 输入:  a = -1, b = 1
 * 输出: 0
 * 样例解释: 返回a+b的结果.
 *
 * 挑战
 * 显然你可以直接 return a + b，但是你是否可以挑战一下不这样做？（不使用 + 等算数运算符）
 *
 */
public class Aplusb {

    public static void main(String[] args) {
        System.out.println(aplusb(6, 5));
    }

    /**
     * a+b是一个非常简单的问题，基本上是编程初学者在hello world后第二个想去尝试完成的功能，
     * 本题将不使用+号及其他算术运算符，采用位运算的方式实现a+b
     * 先举一个十进制加法的例子，比如45+67=112，如果不考虑进位得到的结果是2，只考虑进位得到的结果是110，加起来正好是112，
     * 对于二进制其实也是这样的，因此我们可以将加操作和进位操作分开，二进制不进位加法其实就是异或操作，
     * 而进位操作实际上就是两个数对应位都为1时的左移，考虑到进位次数有限，当进位为0时，加出来的就是答案了
     */
    public static int aplusb(int a, int b) {
        if (b == 0){
            return a;
        }
        //加操作
        int sum = a ^ b;
        //进位操作
        int carry = (a & b) << 1;
        //将加操作结果加上进位操作结果
        return aplusb(sum, carry);
    }
}
