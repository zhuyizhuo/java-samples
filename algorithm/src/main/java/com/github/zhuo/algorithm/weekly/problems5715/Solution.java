package com.github.zhuo.algorithm.weekly.problems5715;

import java.util.Arrays;

public class Solution {

    public int reinitializePermutation(int n) {
        int[] ints = new int[n - 1];
        for (int i = 0; i < n; i++) {
            ints[i] = i;
        }
        int[] newInts = new int[n-1];
        for (int i = 0; i < n; i++) {
            if (i%2 == 0){
                newInts[i] = ints[i/2];
            } else {
                newInts[i] = ints[n/2 + (i-1)/2];
            }
        }
        for (int i = 0; i < n; i++) {
            if (newInts[i] != ints[i]){
                break;
            }
        }
        ints = Arrays.copyOf(newInts, n-1);

        return 0;
    }
}
