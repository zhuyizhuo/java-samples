package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems12;

/**
 * https://leetcode.com/problems/integer-to-roman/
 *
 * 整数转罗马数字
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    /**
     * 初步思路就是每位比对
     */
    public static String intToRoman(int num) {
        if (num < 1 || num > 3999){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = 1;
        while (num / 10 != 0 || num > 0){
            int i = num % 10 * index;
            switch (i){
                case 4 :
                    sb.insert(0,"IV");
                    break;
                case 9 :
                    sb.insert(0,"IX");
                    break;
                case 40:
                    sb.insert(0,"XL");
                    break;
                case 90:
                    sb.insert(0,"XC");
                    break;
                case 400:
                    sb.insert(0,"CD");
                    break;
                case 900:
                    sb.insert(0,"CM");
                    break;
                default:
                    if (i >= 1000) {
                        int i1 = i / 1000;
                        for (int j = 0; j < i1; j++) {
                            sb.insert(0,"M");
                        }
                    } else if(i >= 100){
                        int i1;
                        if (i >= 500) {
                            i1 = (i - 500) / 100;
                        } else {
                            i1 = i / 100;
                        }
                        for (int j = 0; j < i1; j++) {
                            sb.insert(0,"C");
                        }
                        if (i >= 500){
                            sb.insert(0, "D");
                        }
                    } else if(i >= 10){
                        int i1;
                        if(i >= 50) {
                            i1 = (i - 50) / 10;
                        } else {
                            i1 = i / 10;
                        }
                        for (int j = 0; j < i1; j++) {
                            sb.insert(0,"X");
                        }
                        if (i >= 50){
                            sb.insert(0, "L");
                        }
                    } else {
                        int i1 = i;
                        if (i >= 5){
                            i1 -= 5;
                        }
                        for (int j = 0; j < i1; j++) {
                            sb.insert(0,"I");
                        }
                        if (i >= 5){
                            sb.insert(0, "V");
                        }
                    }
            }
            index *= 10;
            num /= 10;
        }
        return sb.toString();
    }

}
