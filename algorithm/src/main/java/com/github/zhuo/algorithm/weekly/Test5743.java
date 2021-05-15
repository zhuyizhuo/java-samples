package com.github.zhuo.algorithm.weekly;

//增长的内存泄露
public class Test5743 {

    public static void main(String[] args) {
//        int[] ints = memLeak(2, 2);
        int[] ints = memLeak(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] memLeak(int memory1, int memory2) {
        int[] resp = new int[3];
        for (int i = 0;; i++) {
            if (memory1 >= memory2){
                if (memory1 < i){
                    resp[0] = i;
                    resp[1] = memory1;
                    resp[2] = memory2;
                    return resp;
                }
                memory1 -= i;
            } else {
                if (memory2 < i){
                    resp[0] = i;
                    resp[1] = memory1;
                    resp[2] = memory2;
                    return resp;
                }
                memory2 -= i;
            }
        }
    }
}
