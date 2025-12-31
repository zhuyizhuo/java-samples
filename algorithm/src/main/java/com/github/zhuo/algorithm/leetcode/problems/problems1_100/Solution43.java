package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

public class Solution43 {
    /**
     * beats 100%
     */
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int[] A=new int[m],B=new int[n];
        for(int i=m-1;i>=0;i--) A[m-1-i]=num1.charAt(i)-'0';//将
        for(int j=n-1;j>=0;j--) B[n-1-j]=num2.charAt(j)-'0';
        int[] C=new int[m+n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                C[i+j]+=A[i]*B[j];
            }
        }
        int t=0;
        for(int i=0;i<C.length;i++){
            t=t+C[i];
            C[i]=t%10;
            t=t/10;
        }
        int k=C.length-1;
        while(k>0&&C[k]==0) k--;
        StringBuilder sb=new StringBuilder();
        while(k>=0) sb.append((char)(C[k--]+'0'));
        return sb.toString();//必须将数字转为char再转为字符串
    }
}
