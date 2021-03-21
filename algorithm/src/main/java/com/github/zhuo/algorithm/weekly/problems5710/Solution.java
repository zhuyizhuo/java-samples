package com.github.zhuo.algorithm.weekly.problems5710;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        //999999984
        System.out.println(getNumberOfBacklogOrders(new int[][]{{7,1000000000,1},{15,3,0},{5,999999995,0},{5,1,1}}));
        //6
        System.out.println(getNumberOfBacklogOrders(new int[][]{{10,5,0},{15,2,1},{25,1,1},{30,4,0}}));
        //5
        System.out.println(getNumberOfBacklogOrders(new int[][]{{10,5,0}}));
        //14
        System.out.println(getNumberOfBacklogOrders(new int[][]{{26,7,0},{26,7,0}}));
        //82
        System.out.println(getNumberOfBacklogOrders(
                new int[][]{{27,30,0},{10,10,1},{28,17,1},{19,28,0},
                        {16,8,1},{14,22,0},{12,18,1},{3,15,0},{25,6,1}}));
    }

    //执行用时: 55 ms
    //内存消耗: 85.8 MB
    public static int getNumberOfBacklogOrders(int[][] orders) {
        TreeMap<Integer,Integer> buyOrder = new TreeMap<>((o1, o2) -> o2 - o1);
        TreeMap<Integer,Integer> sellOrder = new TreeMap<>();
        int length = orders.length;
        long total = 0;
        for (int i = 0; i < length; i++) {
            //采购订单
            if (orders[i][2] == 0){
                int count = orders[i][1];
                if (!sellOrder.isEmpty()){
                    Iterator<Map.Entry<Integer, Integer>> iterator = sellOrder.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<Integer, Integer> entry = iterator.next();
                        if (entry.getKey() <= orders[i][0]) {
                            Integer value = entry.getValue();
                            if (count >= value){
                                count = count - value;
                                total -= value;
                                iterator.remove();
                            } else {
                                sellOrder.put(entry.getKey(), value - count);
                                total -= count;
                                count = 0;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (count > 0){
                    if (buyOrder.get(orders[i][0]) == null){
                        buyOrder.put(orders[i][0], count);
                    } else {
                        buyOrder.put(orders[i][0], count + buyOrder.get(orders[i][0]));
                    }
                    total += count;
                }
            } else {
                //销售订单
                int count = orders[i][1];
                if (!buyOrder.isEmpty()){
                    Iterator<Map.Entry<Integer, Integer>> iterator = buyOrder.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<Integer, Integer> entry = iterator.next();
                        if (entry.getKey() >= orders[i][0]) {
                            Integer value = entry.getValue();
                            if (count >= value){
                                count = count - value;
                                total -= value;
                                iterator.remove();
                            } else {
                                buyOrder.put(entry.getKey(), value - count);
                                total -= count;
                                count = 0;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (count > 0){
                    if (sellOrder.get(orders[i][0]) == null){
                        sellOrder.put(orders[i][0], count);
                    } else {
                        sellOrder.put(orders[i][0], count + sellOrder.get(orders[i][0]));
                    }
                    total += count;
                }
            }
        }
        return (int)(total%1000_000_007);
    }
}
