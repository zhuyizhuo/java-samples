package com.github.zhuo.algorithm.tools;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirectoryTreePrinter {
    // 统计各种文件类型的数量
    private static Map<String, Integer> fileTypeCountMap = new HashMap<>();
    
    public static void main(String[] args) {
        // 动态获取当前项目根目录并拼接目标路径
        String projectRoot = System.getProperty("user.dir");
        File targetDirectory = new File(projectRoot, "src/main/java/com/github/zhuo/algorithm/leetcode");
        
        System.out.println("目标目录: " + targetDirectory.getAbsolutePath());
        System.out.println("目录结构:");
        
        // 递归打印目录树
        printDirectoryTree(targetDirectory, "");
        
        System.out.println("\n统计信息:");
        // 打印所有文件类型的统计结果
        for (Map.Entry<String, Integer> entry : fileTypeCountMap.entrySet()) {
            System.out.println(entry.getKey() + " 文件总数: " + entry.getValue());
        }
        // 计算总文件数
        int totalFiles = fileTypeCountMap.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("总文件数: " + totalFiles);
    }
    
    /**
     * 递归打印目录树
     * @param file 当前文件或目录
     * @param prefix 前缀字符串，用于构建树形结构
     */
    private static void printDirectoryTree(File file, String prefix) {
        if (!file.exists()) {
            System.out.println("文件或目录不存在: " + file.getAbsolutePath());
            return;
        }
        
        // 打印当前文件或目录
        if (file.isDirectory()) {
            System.out.println(prefix + "📁 " + file.getName());
        } else if (file.getName().endsWith(".java")) {
            System.out.println(prefix + "📄 " + file.getName());
        } else {
            System.out.println(prefix + "📋 " + file.getName());
        }
        
        // 如果是文件，统计文件类型
        if (file.isFile()) {
            String fileName = file.getName();
            String fileType;
            int dotIndex = fileName.lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
                // 有扩展名的文件
                fileType = fileName.substring(dotIndex + 1).toLowerCase();
            } else {
                // 无扩展名的文件
                fileType = "无扩展名";
            }
            // 更新统计信息
            fileTypeCountMap.put(fileType, fileTypeCountMap.getOrDefault(fileType, 0) + 1);
        }
        
        // 如果是目录，递归打印子目录和文件
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null && children.length > 0) {
                // 对文件列表进行排序
                Arrays.sort(children, new Comparator<File>() {
                    @Override
                    public int compare(File f1, File f2) {
                        // 目录排在文件前面
                        if (f1.isDirectory() && !f2.isDirectory()) {
                            return -1;
                        } else if (!f1.isDirectory() && f2.isDirectory()) {
                            return 1;
                        }
                        
                        // 都是目录或都是文件，尝试按数字排序
                        String name1 = f1.getName();
                        String name2 = f2.getName();
                        
                        // 提取名称中的数字
                        Long num1 = extractNumbersFromFileName(name1);
                        Long num2 = extractNumbersFromFileName(name2);
                        
                        // 如果两个名称都包含数字，按数字大小排序
                        if (num1 != null && num2 != null) {
                            return Long.compare(num1, num2);
                        } else if (num1 != null) {
                            // 只有第一个名称有数字，排在前面
                            return -1;
                        } else if (num2 != null) {
                            // 只有第二个名称有数字，排在前面
                            return 1;
                        }
                        
                        // 两个名称都没有数字，按字母顺序排序
                        return name1.compareTo(name2);
                    }
                });
                
                for (int i = 0; i < children.length; i++) {
                    boolean isLast = (i == children.length - 1);
                    String newPrefix = prefix + (isLast ? "    " : "|   ");
                    printDirectoryTree(children[i], newPrefix);
                }
            }
        }
    }
    
    /**
     * 从文件名中提取数字
     * @param fileName 文件名
     * @return 提取到的数字，如果没有数字则返回null
     */
    private static Long extractNumbersFromFileName(String fileName) {
        // 移除文件扩展名
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex != -1) {
            fileName = fileName.substring(0, dotIndex);
        }
        
        // 使用正则表达式提取数字
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(fileName);
        
        // 找到第一个数字序列
        if (matcher.find()) {
            try {
                return Long.parseLong(matcher.group());
            } catch (NumberFormatException e) {
                // 如果数字过大无法解析为Long，返回null
                return null;
            }
        }
        
        // 没有找到数字
        return null;
    }
}