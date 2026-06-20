package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 用特殊操作处理字符串 II
 * hard
 */
public class Solution3614 {

    /**
     * beats 96.15%
     */
    public char processStr(String s, long k) {
        char[] arr = s.toCharArray();
        long size = 0;

        for(char c : arr){
            if(c == '*'){
                if(size > 0){
                    size--;
                }
            }
            else if(c == '#'){
                size <<= 1;
            }
            else if(c == '%'){

            }
            else{
                size++;
            }
        }

        if(k >= size){
            return '.';
        }

        for(int i = arr.length - 1; i >= 0; i--){
            char c = arr[i];

            if(c == '*'){
                size++;
            }
            else if(c == '#'){
                long before = size >> 1;
                if(k >= before){
                    k -= before;
                }

                size = before;
            }
            else if(c == '%'){
                k = size - k - 1;
            }
            else{
                if(k == size - 1){
                    return c;
                }
                size--;
            }
        }

        return '.';
    }
}