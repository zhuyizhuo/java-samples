package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class Solution85 {

    /**
     * 3ms beats 95.42%
     */
    public int maximalRectangle(char[][] matrix) {
        int n=matrix[0].length;
        int[] heights=new int[n+1];
        int ans=0;
        for(char[] row:matrix){
            for(int j=0;j<n;j++){
                if(row[j]=='0')heights[j]=0;
                else{
                    heights[j]++;
                }
            }

            ans=Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    private int largestRectangleArea(int[] heights){
        int n=heights.length;
        int[] st=new int[n];
        int top=-1;
        st[++top]=-1;
        int ans=0;
        for(int right=0;right<n;right++){
            int h=heights[right];
            while(top>0&&heights[st[top]]>=h){
                int i=st[top--];
                int left=st[top];
                ans=Math.max(ans,heights[i]*(right-left-1));
            }
            st[++top]=right;
        }
        return ans;
    }
}