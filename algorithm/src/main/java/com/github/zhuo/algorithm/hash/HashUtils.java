package com.github.zhuo.algorithm.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 散列算法工具类
 * 提供常见的散列算法实现，包括MD5、SHA1、SHA256、SHA512等
 */
public class HashUtils {

    /**
     * 计算字符串的MD5哈希值
     * @param input 输入字符串
     * @return MD5哈希值的十六进制表示
     */
    public static String md5(String input) {
        return hash(input, "MD5");
    }

    /**
     * 计算字符串的SHA-1哈希值
     * @param input 输入字符串
     * @return SHA-1哈希值的十六进制表示
     */
    public static String sha1(String input) {
        return hash(input, "SHA-1");
    }

    /**
     * 计算字符串的SHA-256哈希值
     * @param input 输入字符串
     * @return SHA-256哈希值的十六进制表示
     */
    public static String sha256(String input) {
        return hash(input, "SHA-256");
    }

    /**
     * 计算字符串的SHA-512哈希值
     * @param input 输入字符串
     * @return SHA-512哈希值的十六进制表示
     */
    public static String sha512(String input) {
        return hash(input, "SHA-512");
    }

    /**
     * 计算字符串的哈希值
     * @param input 输入字符串
     * @param algorithm 哈希算法名称
     * @return 哈希值的十六进制表示
     */
    private static String hash(String input, String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] hashBytes = messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
            
            // 使用通用的字节数组转十六进制字符串方法
            return bytesToHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("不支持的哈希算法: " + algorithm, e);
        }
    }

    /**
     * 将字节数组转换为十六进制字符串
     * @param bytes 字节数组
     * @return 十六进制字符串
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * 计算带盐值的哈希值
     * @param input 输入字符串
     * @param salt 盐值
     * @param algorithm 哈希算法名称
     * @return 带盐哈希值的十六进制表示
     */
    public static String hashWithSalt(String input, String salt, String algorithm) {
        return hash(input + salt, algorithm);
    }

    /**
     * 测试散列算法工具类
     */
    public static void main(String[] args) {
        String input = "Hello, 散列算法!";
        String salt = "randomSalt123";
        
        System.out.println("输入字符串: " + input);
        System.out.println("MD5哈希值: " + md5(input));
        System.out.println("SHA-1哈希值: " + sha1(input));
        System.out.println("SHA-256哈希值: " + sha256(input));
        System.out.println("SHA-512哈希值: " + sha512(input));
        
        System.out.println("\n带盐值的哈希示例:");
        System.out.println("带盐MD5哈希值: " + hashWithSalt(input, salt, "MD5"));
        System.out.println("带盐SHA-256哈希值: " + hashWithSalt(input, salt, "SHA-256"));
        
        // 测试相同输入的哈希值一致性
        String input2 = "Hello, 散列算法!";
        System.out.println("\n相同输入的哈希一致性测试:");
        System.out.println("原始输入MD5: " + md5(input));
        System.out.println("相同输入MD5: " + md5(input2));
        System.out.println("哈希值相同: " + md5(input).equals(md5(input2)));
    }
}