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
        // 获取指定的com目录
        File targetDirectory = new File("D:\\git\\java-samples\\algorithm\\src\\main\\java\\com\\github\\zhuo\\algorithm\\leetcode");
        
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
                        
                        // 都是目录或都是文件，按名称排序
                        String name1 = f1.getName();
                        String name2 = f2.getName();
                        
                        // 尝试提取数字部分进行数值排序
                        try {
                            // 提取problemsxxx中的数字部分
                            Pattern pattern = Pattern.compile("problems(\\d+)");
                            Matcher matcher1 = pattern.matcher(name1);
                            Matcher matcher2 = pattern.matcher(name2);
                            
                            if (matcher1.find() && matcher2.find()) {
                                int num1 = Integer.parseInt(matcher1.group(1));
                                int num2 = Integer.parseInt(matcher2.group(1));
                                return Integer.compare(num1, num2);
                            }
                        } catch (NumberFormatException e) {
                            // 如果无法解析为数字，回退到字母顺序排序
                        }
                        
                        // 按字母顺序排序
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
}