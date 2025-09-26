package com.github.zhuo.samples;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:
 * @author: zhuo
 */
public class Hash {

    public static int calculateHash(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

        // Convert the first 4 bytes of the hash to an integer
        int hash = ((hashBytes[0] & 0xFF) << 24) |
                ((hashBytes[1] & 0xFF) << 16) |
                ((hashBytes[2] & 0xFF) << 8) |
                (hashBytes[3] & 0xFF);

        return Math.abs(hash) % 100;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String number = "22334455";
        System.out.println(calculateHash(number) + "---" + calculateHash(number)%100);
    }
}
