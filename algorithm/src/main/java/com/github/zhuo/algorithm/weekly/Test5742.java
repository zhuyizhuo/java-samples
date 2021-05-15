package com.github.zhuo.algorithm.weekly;

//将句子排序
public class Test5742 {

    public static void main(String[] args) {
        System.out.println(sortSentence("Myself2 Me1 I4 and3"));
    }

    public static String sortSentence(String s) {
        String[] s1 = s.split(" ");
        String[] resp = new String[10];
        for (int i = 0; i < s1.length; i++) {
            String substring = s1[i].substring(0, s1[i].length() - 1);
            char c = s1[i].charAt(s1[i].length() - 1);
            resp[Character.getNumericValue(c)] = substring;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resp.length; i++) {
            if (resp[i] != null && !"".equals(resp[i])){
                sb.append(resp[i]).append(" ");
            }
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
