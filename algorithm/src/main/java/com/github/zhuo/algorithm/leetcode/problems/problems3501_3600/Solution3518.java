package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

/**
 * 最小回文排列 II
 * hard
 *
 * 给你一个 回文 字符串 s 和一个整数 k。
 *
 * 返回 s 的按字典序排列的 第 k 小 回文排列。如果不存在 k 个不同的回文排列，则返回空字符串。
 *
 * 注意： 产生相同回文字符串的不同重排视为相同，仅计为一次。
 *
 * 如果一个字符串从前往后和从后往前读都相同，那么这个字符串是一个 回文 字符串。
 *
 * 排列 是字符串中所有字符的重排。
 *
 * 如果字符串 a 按字典序小于字符串 b，则表示在第一个不同的位置，a 中的字符比 b 中的对应字符在字母表中更靠前。
 * 如果在前 min(a.length, b.length) 个字符中没有区别，则较短的字符串按字典序更小。
 */
public class Solution3518 {

    //     【题意】：原数组，可以任意排列，且【所有字符  都要用上】
    // 则：唯独一个可以【是 奇数】，
    // 其他的都需要是【偶数个】
    // 查看由这【偶数个，分别轮转外层】，是否能够【k 个】
    // 则： 若偶数个（包含2k+1个）是 abc:
    // 一共有：abc acb bac bca cab cba 6个排列=3！个排列
    /**
     * beats 100%
     */
    public String smallestPalindrome(String s, int k) {
        int n=s.length();
        int nhalf=n/2;
        int[]cnt=new int[26];
        char[]sa=s.toCharArray();
        for(int i=0;i<nhalf;i++){
            cnt[sa[i]-'a']++;
        }
        int[]palinCnt=new int[26];
        long perm=1;
        int i=nhalf-1,j=25;

        for(; i>=0&&perm<k;i--){
            while(palinCnt[j]==cnt[j])j--;

            palinCnt[j]++;
            perm=perm*(nhalf-i)/palinCnt[j];
        }

        if(perm<k)return "";

        StringBuilder ans=new StringBuilder(n);

        for(int ch=0;ch<=j;ch++){
            //need jdk 21
            ans.repeat('a'+ch,cnt[ch]-palinCnt[ch]);
        }

        int j0=j;
        for(i++;i<nhalf; i++){
            for(j=j0;j<26;j++){
                if(palinCnt[j]==0)continue;
                long pcur=perm*palinCnt[j]/(nhalf-i);

                if(pcur>=k){
                    ans.append((char)('a'+j));

                    palinCnt[j]--;
                    perm=pcur;
                    break;
                }
                k-=pcur;
            }
        }
        StringBuffer srev=new StringBuffer(ans).reverse();

        if(n%2>0){
            ans.append(s.charAt(n/2));
        }
        ans.append(srev);
        return ans.toString();
    }
}