package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems8;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31, 2^31 − 1]。如果数值超过这个范围，请返回 2^31 − 1 或 −2^31 。
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi( "42"));
    }

    /**
     * 小小的一道题 以为很简单 却有挺多坑
     * 需考虑各种边界值、 正负号连续出现的情况、 超过 int 最大最小丢精度问题
     */
    public static int myAtoi(String s) {
        String trim = s.trim();
        if (trim.length() == 0){
            return 0;
        }
        char c = trim.charAt(0);
        //累加值 声明为 long 否则 int 累加超过最大值精度丢失
        long sum = 0;
        boolean isNegative = '-' == c;
        boolean isPositive = '+' == c;
        if (Character.isDigit(c)) {
            sum += Character.getNumericValue(c);
        } else if (!isNegative && !isPositive) {
            //首字符 非数字非符号 直接返回
            return 0;
        }
        for (int i = 1; i < trim.length(); i++) {
            char c1 = trim.charAt(i);
            if (Character.isDigit(c1)){
                int numericValue = Character.getNumericValue(c1);
                if (!isNegative && sum * 10 + numericValue > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                } else if (isNegative && -(sum * 10 + numericValue) < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                sum = sum * 10 + numericValue;
            } else {
                break;
            }
        }
        return isNegative ? (int)-sum : (int)sum;
    }
}
