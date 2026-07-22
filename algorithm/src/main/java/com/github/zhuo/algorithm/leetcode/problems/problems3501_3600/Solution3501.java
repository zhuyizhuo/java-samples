package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作后最大活跃区段数 II
 * hard
 */
public class Solution3501 {
    int binarySearchL(List<Section> sections,int x){
        int l=0,r=sections.size()-1;
        while (l<=r){
            int m=(l+r)/2;
            if(sections.get(m).l<x){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return l;
    }

    int binarySearchR(List<Section> sections, int x){
        int l=0,r=sections.size()-1;
        while (l<=r){
            int m=(l+r)/2;
            if(sections.get(m).l+sections.get(m).len<=x){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return r;
    }

    record Section(int l,int len){}

    /**
     * beats 100%
     */
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int n=s.length(),cnt=0,total1=0;
        List<Section> sections=new ArrayList<>();
        sections.add(new Section(-1,1));

        int[] belong=new int[n];
        for (int i = 0; i < n; i++) {
            cnt++;
            if(i==n-1||chars[i]!=chars[i+1]){
                if(chars[i]=='0'){
                    sections.add(new Section(i+1-cnt,cnt));
                    for (int j = i+1-cnt; j < i+1; j++) {
                        belong[j]=sections.size()-1;
                    }
                }else{
                    for (int j = i+1-cnt; j < i+1; j++) {
                        belong[j]=sections.size()-1;
                    }
                    total1+=cnt;
                }
                cnt=0;
            }
        }
        sections.add(new Section(n,1));

        int m=31-Integer.numberOfLeadingZeros(sections.size());
        int[][] st=new int[m+1][sections.size()];

        for(int i=1;i<=m;i++){
            for (int j = 0; j + (1<<i) <= sections.size(); j++) {
                st[i][j]=Math.max(sections.get(j+(1<<(i-1))-1).len+sections.get(j+(1<<(i-1))).len,Math.max(st[i-1][j],st[i-1][j+(1<<(i-1))]));
            }
        }

        List<Integer> res=new ArrayList<>(queries.length);
        for (int i = 0; i < queries.length; i++) {
            int l=queries[i][0],r=queries[i][1];
            int L = belong[l]+1;
            int R = s.charAt(r)=='0'?belong[r]-1:belong[r];
            int tmp=0;
            if(L==R+1){
                tmp=add(r-sections.get(L).l+1,sections.get(R).len-(l-sections.get(R).l));
            }else if(L<=R){
                int delta=31-Integer.numberOfLeadingZeros(R-L+1);
                tmp=Math.max(st[delta][L],st[delta][R+1-(1<<delta)]);
                tmp=Math.max(tmp,add(r-sections.get(R+1).l+1,sections.get(R).len));
                tmp=Math.max(tmp,add(sections.get(L-1).len-(l-sections.get(L-1).l),sections.get(L).len));
            }
            res.add(total1+tmp);
        }
        return res;
    }

    int add(int x,int y){
        return x>0&&y>0?x+y:0;
    }
}