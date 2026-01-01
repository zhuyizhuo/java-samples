package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * https://leetcode-cn.com/problems/plus-one/
 *
 * 加一
 */
public class Solution66 {

    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{9,9,9}));
    }

    /**
     * beats 100%
     */
    public static int[] plusOne(int[] digits) {
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (i == digits.length - 1){
                digit += 1;
            }
            if (carry){
                digit += 1;
            }
            if (digit >= 10){
                digits[i] = digit - 10;
                carry = true;
            } else {
                digits[i] = digit;
                carry = false;
            }
        }
        if (carry){
            int[] rtn = new int[digits.length + 1];
            rtn[0] = 1;
            System.arraycopy(digits, 0, rtn, 1, rtn.length - 1);
            return rtn;
        }
        return digits;
    }

    /**
     * beats 100%
     */
    public int[] plusOne1(int[] digits) {
        int res=1,n=digits.length;
        for(int i=n-1;i>=0;i--) {
            res+=digits[i];
            digits[i]=res%10;
            res/=10;
            if(res==0) return digits;
        }
        int[] ans=new int[n+1];
        ans[0]=1;
        for(int i=1;i<=n;i++) {
            ans[i]=digits[i-1];
        }
        return ans;
    }
}