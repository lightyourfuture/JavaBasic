package com.itheima.string;

import java.util.Random;

// 目标:完成随机产生验证码的功能
// 随机产生n个字符，每个字符是0-9，a-z,A-Z的任意一个
public class StringTest5 {
    public static void main(String[] args) {
        // 调用方法
        String code = createCode(6);
        System.out.println("验证码:" + code);
    }

    // 设计一个方法,返回指定位数的验证码
    public static String createCode(int n) {
        String code = "";
        String data = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            // 随机一个字符范围内的索引
            int index = r.nextInt(data.length());
            code = code + data.charAt(index);
        }
        return code;
    }
}
