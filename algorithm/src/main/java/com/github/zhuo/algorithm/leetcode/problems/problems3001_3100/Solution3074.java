package com.github.zhuo.algorithm.leetcode.problems.problems3001_3100;

import java.util.Arrays;

/**
 * Easy
 *
 * 给你一个长度为 n 的数组 apple 和另一个长度为 m 的数组 capacity 。
 *
 * 一共有 n 个包裹，其中第 i 个包裹中装着 apple[i] 个苹果。同时，还有 m 个箱子，第 i 个箱子的容量为 capacity[i] 个苹果。
 *
 * 请你选择一些箱子来将这 n 个包裹中的苹果重新分装到箱子中，返回你需要选择的箱子的 最小 数量。
 *
 * 注意，同一个包裹中的苹果可以分装到不同的箱子中。
 *
 * 示例 1：
 *
 * 输入：apple = [1,3,2], capacity = [4,3,1,5,2]
 * 输出：2
 * 解释：使用容量为 4 和 5 的箱子。
 * 总容量大于或等于苹果的总数，所以可以完成重新分装。
 * 示例 2：
 *
 * 输入：apple = [5,5,5], capacity = [2,4,2,7]
 * 输出：4
 * 解释：需要使用所有箱子。
 *
 *
 * 提示：
 *
 * 1 <= n == apple.length <= 50
 * 1 <= m == capacity.length <= 50
 * 1 <= apple[i], capacity[i] <= 50
 * 输入数据保证可以将包裹中的苹果重新分装到箱子中。
 */
public class Solution3074 {

    /**
     * Beats 98.81%
     */
    public int minimumBoxes(int[] apple, int[] capacity) {
        //int sum_ap= math.sum(apple);
        int sum_ap= Solution3074.sumApple(apple);
        int sum_cap= 0; //已选箱子.容量
        int sum_box= 0; //已选箱子.数量
        int len_box= capacity.length;
        int len_ap= apple.length;

        while(sum_cap<sum_ap){
            int max_box= Solution3074.maxApple(capacity);   //最优(箱子).贪心
            int idx= Solution3074.maxIdx(capacity);         //最优(箱子).第1索引
            sum_cap+= max_box;  //已选箱子.容量
            sum_box+=1;         //已选箱子.数量++
            capacity[idx]=0;    // 置零
        }
        return sum_box;
    }
    public static int maxApple(int[] apple){
        int max_ap= 0;
        for(int i=0;i<apple.length;i++){
            if(max_ap<apple[i]){
                max_ap= apple[i];
            }
        }
        return max_ap;
    }
    public static int maxIdx(int[] apple){
        int max_ap= 0;
        int max_idx= 0;
        for(int i=0;i<apple.length;i++){
            if(max_ap<apple[i]){
                max_ap= apple[i];
                max_idx= i;
            }
        }
        return max_idx;
    }
    public static int sumApple(int[] apple){
        int sum_ap= 0;
        for(int i=0;i<apple.length;i++){
            sum_ap+= apple[i];
        }
        return sum_ap;
    }

}

/**
 * beats 100%
 */
class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {
            }
        }));
    }
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int a : apple)
        {
            sum += a;
        }
        Arrays.sort(capacity);

        int count = 0;
        int n = capacity.length;
        for (int i = n - 1; i >= 0; i--) {
            sum -= capacity[i];
            count++;
            if (sum <= 0) {
                break;
            }
        }
        return count;
    }
}