package com.github.zhuo.algorithm.leetcode.problems.problems1601_1700.problems1603;

/**
 * 执行用时： 11 ms , 在所有 Java 提交中击败了 36.28% 的用户
 * 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 56.48% 的用户
 */
public class ParkingSystem {

    private int[] parkingCar;

    public ParkingSystem(int big, int medium, int small) {
        parkingCar = new int[4];
        parkingCar[big] = big;
        parkingCar[medium] = medium;
        parkingCar[small] = small;
    }

    public boolean addCar(int carType) {
        if (parkingCar[carType] == 0){
           return false;
        }
        parkingCar[carType] -= 1;
        return true;
    }

}
