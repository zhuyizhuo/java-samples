package com.github.zhuo.algorithm.leetcode.problems1_100.problems36;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * 有效的数独
 *
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 *
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 */
public class ValidSudoku {

    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        }));
    }

    /**
     * 暴力解法
     *
     * 两层循环
     * 时间复杂度是 O(n^2)
     */
    public static boolean isValidSudoku(char[][] board) {
        //每行数据
        List<Character> rowList = null;
        //每列数据 key 为列数  值为每列数据
        Map<Integer, List<Character>> lineMap = new HashMap<>();
        //每个 3x3 宫格数据 外层 map 存在 3 个键值对 分别对应 每三行数据，内层 map 存在 3个键值对 分别对应每三列
        Map<Integer, Map<Integer, List<Character>>> lineBox = new HashMap();
        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            //每行创建一个 rowList
            rowList = new ArrayList<>();
            Map<Integer, List<Character>> boxMap = lineBox.get(i / 3);
            if (boxMap == null){
                boxMap = new HashMap<>();
                lineBox.put(i/3, boxMap);
            }
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '.'){
                    continue;
                }
                Character o = Character.valueOf(chars[j]);
                //每行内数字需唯一 不唯一则非有效数独
                if (rowList.contains(o)){
                    return false;
                } else {
                    rowList.add(o);
                }
                //获取每列数据比对
                List<Character> list = lineMap.get(j);
                if (list == null){
                    ArrayList<Character> objects = new ArrayList<>();
                    objects.add(o);
                    lineMap.put(j, objects);
                } else if (list.contains(o)){
                    return false;
                } else {
                    list.add(o);
                }
                //获取 3x3 宫内数据比对
                List<Character> list1 = boxMap.get(j / 3);
                if (list1 == null){
                    list1 = new ArrayList<>();
                    list1.add(o);
                    boxMap.put(j / 3, list1);
                } else if(list1.contains(o)){
                    return false;
                } else {
                    list1.add(o);
                }
            }
        }
        return true;
    }

}
