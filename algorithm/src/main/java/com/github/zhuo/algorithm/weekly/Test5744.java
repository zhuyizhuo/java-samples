package com.github.zhuo.algorithm.weekly;

import java.util.Arrays;

//旋转盒子
public class Test5744 {

    public static void main(String[] args) {
//        char[][] chars = rotateTheBox(new char[][]{{'#', '.', '*', '.'}, {'#', '#', '*', '.'}});
//        char[][] chars = rotateTheBox(new char[][]{{'#', '.', '#'}});
        char[][] chars = rotateTheBox(new char[][]{{'#','#','*','.','*','.'}, {'#','#','#','*','.','.'}, {'#','#','#','.','#','.'}});
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] rotateTheBox(char[][] box) {
        char[][] resp = new char[box[0].length][box.length];
        for (int i = 0; i < resp.length; i++) {
            Arrays.fill(resp[i],'.');
        }
        //原盒子宽 即 新盒子高
        for (int boxWidth = box[0].length - 1; boxWidth >= 0; boxWidth--) {
            // 原盒子高 即 新盒子宽
            for (int boxDeep = box.length - 1; boxDeep >= 0; boxDeep--) {
                //新盒子的当前高度 = 原盒子的当前宽度
                int deep = boxWidth;
                // 因为是旋转90度 所以原盒子最高的 为新盒子宽度最靠前的
                // 所以新盒子的当前宽度 = 原盒子的总高度 - 1 - 原盒子当前高度
                int width = box.length - 1 - boxDeep;
                if (box[boxDeep][boxWidth] == '.' || box[boxDeep][boxWidth] == '*'){
                    resp[deep][width] = box[boxDeep][boxWidth];
                } else if (box[boxDeep][boxWidth] == '#'){
                    for (int k = deep; k < box[0].length; k++) {
                        if (resp[k][width] == '*' || resp[k][width] == '#'){
                            resp[k-1][width] = '#';
                            break;
                        }
                        if (k == box[0].length - 1){
                            resp[k][width] = '#';
                        }
                    }
                }
            }
        }
        return resp;
    }
}
