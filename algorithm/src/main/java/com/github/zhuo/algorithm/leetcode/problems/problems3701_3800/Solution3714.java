package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

import java.util.HashMap;

/**
 * 最长的平衡子串 II
 *
 * 给你一个只包含字符 'a'、'b' 和 'c' 的字符串 s。
 *
 * 如果一个 子串 中所有 不同 字符出现的次数都 相同，则称该子串为 平衡 子串。
 *
 * 请返回 s 的 最长平衡子串 的 长度 。
 *
 * 子串 是字符串中连续的、非空 的字符序列。
 */
public class Solution3714 {

    /**
     * beats 97.64%
     */
    public int longestBalanced(String s) {
        char[]str=s.toCharArray();
        int strlen=str.length;
        int maxLen=0;

        for(int i=0;i<strlen;){
            int right=i;
            while(right+1<strlen&&str[right+1]==str[i])right++;
            maxLen=Math.max(maxLen,right-i+1);
            i=right+1;
        }
        if(maxLen==strlen)return maxLen;
        maxLen=Math.max(maxLen,find2(str,'a','b'));
        maxLen=Math.max(maxLen,find2(str,'b','c'));
        maxLen=Math.max(maxLen,find2(str,'c','a'));
        if(maxLen==strlen)return maxLen;


        int []cnt=new int[3];
        HashMap<Long,Integer> posMap = new HashMap<Long,Integer>();
        posMap.put((0L+strlen)<<20 |(0L+strlen),-1);
        for(int i=0;i<strlen;i++){
            char ch=str[i];
            cnt[ch-'a']++;
            long f1=cnt[0]-cnt[1]+strlen;
            long f2=cnt[1]-cnt[2]+strlen;
            long f=f1<<20|f2;
            if(posMap.containsKey(f)){
                int idx=posMap.get(f);
                int len=i-idx;
                maxLen=Math.max(maxLen,len);
            }else posMap.put(f,i);
        }
        return maxLen;
    }
    public int find2(char[] str,char a,char b) {
        int strlen=str.length;
        int maxLen=0;
        for(int i=0;i<strlen;){
            if(str[i]!=a&&str[i]!=b){i++;continue;}
            int end=i;
            HashMap<Integer,Integer>posMap = new HashMap<Integer,Integer>();
            posMap.put(0,i-1);
            int suma=0,sumb=0;
            for(;end<str.length && (str[end]==a ||str[end]==b);end++){
                if(str[end]==a)suma++;
                else sumb++;
                int f=sumb-suma;
                if(posMap.containsKey(f)){
                    int L1=posMap.get(f);
                    int le=end-L1;
                    maxLen=Math.max(maxLen,le);

                }else posMap.put(f,end);

            }
            i=end;
        }
        return maxLen;
    }
}