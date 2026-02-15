package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * https://leetcode-cn.com/problems/add-binary/
 * 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 */
public class Solution67 {

    public static void main(String[] args) {
        System.out.println(addBinary("1111","1"));
    }

    public static String addBinary(String a, String b) {
        int index = a.length() - 1;
        if (index == -1){
            return b;
        }
        int bIndex = b.length() - 1;
        if (bIndex == -1){
            return a;
        }
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        while (index >= 0 || bIndex >= 0){
            char c = '0';
            if (index >= 0){
                c = a.charAt(index);
            }
            char c1 = '0';
            if (bIndex >= 0){
                c1 = b.charAt(bIndex);
            }
            if (c == '1' && c1 == '1'){
                if (carry){
                    sb.append('1');
                } else {
                    sb.append('0');
                    carry = true;
                }
            } else if (carry){
                if (c == '1' || c1 == '1'){
                    sb.append('0');
                } else {
                    sb.append('1');
                    carry = false;
                }
            } else {
                if (c == '1' || c1 == '1'){
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            index--;
            bIndex--;

        }
        if (carry){
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    /**
     * beats 99.65%
     */
    public String addBinary1(String a, String b) {
        if (a.length() < b.length()) return addBinary1(b, a);  // 保证a的长度>=b的长度, 简化代码

        int n = a.length(), m = b.length();
        char[] ans = new char[n + 1];
        int carry = 0;  // 进位

        for (int i = n - 1, j = m - 1; i >= 0; i--, j--) {
            int x = a.charAt(i) - '0';
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            ans[i + 1] = (char) (sum % 2 + '0');
            carry = sum / 2;
        }

        ans[0] = (char) (carry + '0');
        return new String(ans, carry ^ 1, n + carry);

    }
}
