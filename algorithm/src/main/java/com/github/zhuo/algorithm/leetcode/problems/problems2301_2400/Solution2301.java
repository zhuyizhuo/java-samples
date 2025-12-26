package com.github.zhuo.algorithm.leetcode.problems.problems2301_2400;

public class Solution2301 {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        /**
         寻找长度为sub.length的字串 在s中
         然后遍历字串
         如果s的字串的字符不等于sub尝试替换
         */
        boolean[][] map = new boolean[128][128];
        // 'a' 就是整数 97 'A' 为32 '0'为48
        for(char[] arr : mappings){
            map[arr[0]][arr[1]]=true;
        }
        int sub_len = sub.length();
        int len = s.length();
        char[] cs = s.toCharArray();
        char[] csub = sub.toCharArray();
        for(int i=0;i+sub_len<=len;++i){
            boolean flag = true;
            for(int j=0;j<sub_len;++j){
                if(cs[i+j]!=csub[j]&&!map[csub[j]][cs[i+j]]){
                    flag=false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}
