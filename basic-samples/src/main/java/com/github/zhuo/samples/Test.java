package com.github.zhuo.samples;


import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @author: zhuo
 */
public class Test {

    public static void main(String[] args) {
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> add(1, 2));
        Integer join = integerCompletableFuture.join();
        System.out.println(join);
    }

    public static int add(Integer a , Integer b){
        System.out.println("start");
        return a+b;
    }
}
