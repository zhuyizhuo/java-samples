package com.github.zhuo.algorithm.leetcode.problems.problems101_200.problems168;

/**
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 * Excel表列名称
 * 难度 简单
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 约束:
 *     1 <= columnNumber <= 2^31 - 1
 */
public class ExcelSheetColumnTitle {

    public static void main(String[] args) {
        ExcelSheetColumnTitle excelSheetColumnTitle = new ExcelSheetColumnTitle();
//        System.out.println(excelSheetColumnTitle.convertToTitle(701));
//        System.out.println(excelSheetColumnTitle.convertToTitle(28));
//        System.out.println(excelSheetColumnTitle.convertToTitle(1));
        System.out.println(excelSheetColumnTitle.convertToTitle(52));
//        System.out.println(excelSheetColumnTitle.convertToTitle(Integer.MAX_VALUE));
    }

    String[] s = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    // 27 进制
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        if (columnNumber <= 26){
            return s[columnNumber-1];
        }

        while (columnNumber > 0){
            System.out.println(columnNumber);
            if (columnNumber % 26 == 0){
                if (columnNumber <= 26){
                    sb.append(s[columnNumber - 1]);
                    break;
                } else {
                    sb.append(s[25]);
                }
            } else {
                sb.append(s[columnNumber % 26 - 1]);
            }
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}
