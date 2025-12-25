package com.github.zhuo.algorithm.leetcode.problems.problems301_400;

/**
 * https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * 验证二叉树的前序序列化
 * 难度 中等
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 */
public class Solution331 {

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("9,#"));
    }

    /**
     * 思路
     *  叶子节点的两个节点为空节点 # ，所以我们可以把叶子节点例如 3,#,# 替换为 #。
     *  循环处理字符串中所有的叶子节点，直至没有可替换的叶子节点为止，判断最终的字符串是否为 # ，如果是 #， 则为合法二叉树
     *
     * 执行用时： 18 ms , 在所有 Java 提交中击败了 5.77% 的用户
     * 内存消耗： 39.7 MB , 在所有 Java 提交中击败了 5.18% 的用户
     */
    public static boolean isValidSerialization(String preorder) {
        int length = preorder.length();
        while (true){
            preorder = preorder.replaceAll("\\d+,#,#", "#");
            if (preorder.length() == length){
                break;
            }
            length = preorder.length();
        }
        return "#".equals(preorder);
    }

}
