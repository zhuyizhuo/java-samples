package com.github.zhuo.algorithm.leetcode.problems15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public static void main(String[] args) {
        //todo
//        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSum(new int[]{3,0,-2,-1,1,2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
//        System.out.println(Arrays.asList(nums).stream().collect(Collect));
        if (nums[0] > 0 || nums[nums.length - 1] < 0){
            return new ArrayList<>();
        }
        List l = new ArrayList();
        addThreeSum(l, nums);
        return l;
    }

    private static void addThreeSum(List l, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        List<Integer> integerList = new ArrayList();
        Map<String,String> m = new HashMap<>();
        while (left < right - 1){
            boolean isBreak = false;
            int leftNum = nums[left];
            int rightNum = nums[right];
            System.out.println("左:"+leftNum+",右:"+rightNum);
            sum = leftNum + rightNum;
            //1左2右 小于 0 左指针右移
            int oneLeftTwoRight = sum + nums[right - 1];
            System.out.println("1左2右:"+oneLeftTwoRight);
            if (oneLeftTwoRight < 0){
                left ++;
                continue;
            } else if (oneLeftTwoRight == 0){
                integerList.add(leftNum);
                integerList.add(rightNum);
                integerList.add(nums[right - 1]);
                if (m.get(integerList.toString()) == null){
                    l.add(integerList);
                    m.put(integerList.toString(),"");
                }
                integerList = new ArrayList<>();
                left++;
                continue;
            } else {
                isBreak = true;
//                System.out.println("一左两右" + oneLeftTwoRight + "大于0");
            }
            //1左2右大于0
            int twoLeftOneRight = sum + nums[left + 1];
            //两左一右大于0 右指针左移
            System.out.println("两左一右:" + twoLeftOneRight);
            if (twoLeftOneRight > 0){
                right --;
                continue;
            } else if(twoLeftOneRight == 0){
                integerList.add(leftNum);
                integerList.add(rightNum);
                integerList.add(nums[left + 1]);
                if (m.get(integerList.toString()) == null){
                    l.add(integerList);
                    m.put(integerList.toString(),"");
                }
                integerList = new ArrayList<>();
                right--;
                continue;
            } else {
                if (isBreak){
                    right--;
                }
//                System.out.println("两左一右小于0");
            }
        }
    }

}
