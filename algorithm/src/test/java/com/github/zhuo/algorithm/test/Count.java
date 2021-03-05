package com.github.zhuo.algorithm.test;

import java.io.File;

public class Count {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        String dir = "leetcode/problems";
        System.out.println(property);
        File file;
        int count = 0;
        for (int i = 0; i < 2000; i++) {
            file = new File(property + "/algorithm/src/main/java/com/github/zhuo/algorithm/" + dir + i);
            if (file.exists()){
                String[] list = file.list();
                if (list != null && list.length != 0){
                    count++;
                    for (int j = 0; j < list.length; j++) {
                        System.out.println(list[j]);
                    }
                }
            }
        }
        System.out.println("共做题:" + count);
    }
}
