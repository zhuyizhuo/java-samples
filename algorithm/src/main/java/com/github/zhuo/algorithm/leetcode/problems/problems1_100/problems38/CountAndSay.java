package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems38;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * 外观数列
 */
public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(29));
    }

    /**
     * beats 98.33%
     *
     * beats 100% 的是个穷举 switch
     */
    public static String countAndSay(int n) {
        if (n == 0){
            return "";
        }
        String desc = "1";
        for (int i = 1; i < n; i++) {
            desc = say(desc);
        }
        return desc;
    }

    private static String say(String desc) {
        char last = desc.charAt(0);
        int lastCount = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < desc.length(); i++) {
            if (last == desc.charAt(i)){
                lastCount ++;
            } else {
                sb.append(lastCount).append(last);
                lastCount = 1;
                last = desc.charAt(i);
            }
            if (i == desc.length() - 1){
                sb.append(lastCount).append(last);
            }
        }
        if (sb.length() == 0){
            sb.append(lastCount).append(last);
        }
        return sb.toString();
    }
}
