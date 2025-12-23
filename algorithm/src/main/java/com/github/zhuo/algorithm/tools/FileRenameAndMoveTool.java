package com.github.zhuo.algorithm.tools;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRenameAndMoveTool {

    /**
     * 读取文件内容（Java 8兼容）
     */
    private static String readFileContent(Path filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }

    /**
     * 写入文件内容（Java 8兼容）
     */
    private static void writeFileContent(Path filePath, String content) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            writer.write(content);
        }
    }

    public static void main(String[] args) {
        String packageName = "problems901_1000";
        // 指定源包路径
        String sourcePackagePath = "d:\\git\\java-samples\\algorithm\\src\\main\\java\\com\\github\\zhuo\\algorithm\\leetcode\\problems\\"+packageName;
        
        // 目标包路径（与源包路径相同，因为要移动到该包下）
        String targetPackagePath = sourcePackagePath;
        
        // 目标包名（根据路径生成）
        String targetPackageName = getPackageNameFromPath(targetPackagePath);
        
        try {
            // 获取所有子包
            List<Path> subPackages = getSubPackages(Paths.get(sourcePackagePath));
            
            // 操作日志
            List<String> log = new ArrayList<>();
            log.add("操作开始：" + new Date());
            log.add("源包路径：" + sourcePackagePath);
            log.add("目标包路径：" + targetPackagePath);
            log.add("目标包名：" + targetPackageName);
            log.add("");
            
            // 处理每个子包
            for (Path subPackage : subPackages) {
                String subPackageName = subPackage.getFileName().toString();
                
                // 从子包名中提取数字部分，如problems1818 -> 1818
                String problemNumber = extractProblemNumber(subPackageName);
                if (problemNumber == null) {
                    log.add("跳过子包（无法提取问题编号）：" + subPackageName);
                    log.add("");
                    continue;
                }
                
                // 目标文件名
                String targetFileName = "Solution" + problemNumber + ".java";
                Path targetFilePath = Paths.get(targetPackagePath, targetFileName);
                
                // 获取子包中的Java文件
                List<Path> javaFiles = getJavaFiles(subPackage);
                
                if (javaFiles.isEmpty()) {
                    log.add("子包" + subPackageName + "中没有Java文件");
                    log.add("");
                    continue;
                }
                
                if (javaFiles.size() > 1) {
                    log.add("警告：子包" + subPackageName + "中有多个Java文件，仅处理第一个文件");
                }
                
                // 处理第一个Java文件
                Path sourceFilePath = javaFiles.get(0);
                String sourceFileName = sourceFilePath.getFileName().toString();
                
                log.add("处理子包：" + subPackageName);
                log.add("  源文件：" + sourceFileName);
                log.add("  目标文件：" + targetFileName);
                
                try {
                    // 读取源文件内容（Java 8兼容）
                    String content = readFileContent(sourceFilePath);
                    
                    // 修改包声明
                    String updatedContent = updatePackageDeclaration(content, targetPackageName);
                    
                    // 修改类名
                    String className = extractClassName(sourceFileName);
                    updatedContent = updateClassName(updatedContent, className, "Solution" + problemNumber);
                    
                    // 写入目标文件（Java 8兼容）
                    writeFileContent(targetFilePath, updatedContent);
                    
                    log.add("  ✅ 迁移成功");
                } catch (Exception e) {
                    log.add("  ❌ 迁移失败：" + e.getMessage());
                }
                
                log.add("");
            }
            
            log.add("操作结束：" + new Date());
            
            // 打印日志
            for (String line : log) {
                System.out.println(line);
            }
            
            // 将日志写入文件
            writeLogToFile(log);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取指定路径下的所有子包（目录）
     */
    private static List<Path> getSubPackages(Path parentPath) throws IOException {
        List<Path> subPackages = new ArrayList<>();
        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(parentPath, Files::isDirectory)) {
            for (Path path : stream) {
                subPackages.add(path);
            }
        }
        
        return subPackages;
    }
    
    /**
     * 获取指定路径下的所有Java文件
     */
    private static List<Path> getJavaFiles(Path directoryPath) throws IOException {
        List<Path> javaFiles = new ArrayList<>();
        
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath, "*.java")) {
            for (Path path : stream) {
                javaFiles.add(path);
            }
        }
        
        return javaFiles;
    }
    
    /**
     * 从子包名中提取问题编号，如problems1818 -> 1818
     */
    private static String extractProblemNumber(String subPackageName) {
        Pattern pattern = Pattern.compile("problems(\\d+)");
        Matcher matcher = pattern.matcher(subPackageName);
        
        if (matcher.find()) {
            return matcher.group(1);
        }
        
        return null;
    }
    
    /**
     * 从文件路径中获取包名
     */
    private static String getPackageNameFromPath(String path) {
        // 将文件路径转换为包名
        String packagePath = path.replace("d:\\git\\java-samples\\algorithm\\src\\main\\java\\", "");
        return packagePath.replace(File.separatorChar, '.');
    }
    
    /**
     * 从文件名中提取类名（去掉.java后缀）
     */
    private static String extractClassName(String fileName) {
        if (fileName.endsWith(".java")) {
            return fileName.substring(0, fileName.length() - 5);
        }
        return fileName;
    }
    
    /**
     * 更新文件中的包声明
     */
    private static String updatePackageDeclaration(String content, String targetPackageName) {
        Pattern pattern = Pattern.compile("^package\\s+[^;]+;", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(content);
        
        if (matcher.find()) {
            return matcher.replaceFirst("package " + targetPackageName + ";");
        }
        
        // 如果没有找到包声明，在文件开头添加
        return "package " + targetPackageName + ";\n\n" + content;
    }
    
    /**
     * 更新文件中的类名
     */
    private static String updateClassName(String content, String oldClassName, String newClassName) {
        // 替换类声明
        String classDeclarationPattern = "class\\s+" + oldClassName + "\\s+";
        content = content.replaceAll(classDeclarationPattern, "class " + newClassName + " ");
        
        // 替换构造函数
        String constructorPattern = oldClassName + "\\s*\\(";
        content = content.replaceAll(constructorPattern, newClassName + "(");
        
        // 替换变量声明（包括实例变量和局部变量）
        String variableDeclarationPattern = "(\\s|^)" + oldClassName + "\\s+([a-zA-Z_$][a-zA-Z0-9_$]*)";
        content = content.replaceAll(variableDeclarationPattern, "$1" + newClassName + " $2");
        
        // 替换方法参数中的类名
        String parameterPattern = "(\\s|,)" + oldClassName + "(\\s+[a-zA-Z_$][a-zA-Z0-9_$]*|\\s*,|\\s*\\))";
        content = content.replaceAll(parameterPattern, "$1" + newClassName + "$3");
        
        return content;
    }
    
    /**
     * 将日志写入文件
     */
    private static void writeLogToFile(List<String> log) throws IOException {
        Path logFilePath = Paths.get("file_rename_move_log.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(logFilePath, StandardCharsets.UTF_8)) {
            for (String line : log) {
                writer.write(line);
                writer.newLine();
            }
        }
        System.out.println("\n日志已写入文件：" + logFilePath.toAbsolutePath());
    }
}