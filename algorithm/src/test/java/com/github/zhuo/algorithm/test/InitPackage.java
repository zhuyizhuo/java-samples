package com.github.zhuo.algorithm.test;

import java.io.File;

/**
 * 初始化包结构
 */
public class InitPackage {

    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        String dir = "leetcode/problems/problems";
//        String dir = "lintcode/problem";
        System.out.println(property);
        File file;
        for (int i = 1854; i < 1857; i++) {
            file = new File(property + "/algorithm/src/main/java/com/github/zhuo/algorithm/" + dir + i);
            if (!file.exists()){
                file.mkdirs();
            }
        }
    }

}
