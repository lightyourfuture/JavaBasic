package com.itheima;

public class Test4 {
    public static void main(String[] args) {
        // 目标:完成数字加密的案例
        String password = encrypt(1983);
        System.out.println("加密后的密码:" + password);
    }

    public static String encrypt(int number) {
        // 1.把这个密码拆分成每一位数字
        int[] numbers = split(number);
        // 2.把每一位数字加5,然后对10取余数
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (numbers[i] + 5) % 10;
        }
        // 3.反转数组
        reverse(numbers);
        // 4.把每一位数字拼接成一个字符串
        String result = "";
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        // 5.返回加密后的密码
        return result;

    }

    public static int[] split(int number) {
        // 1.定义一个数组,用于存储每一位数字
        int[] arr = new int[4];
        // 2.定义一个变量,记录数组的索引
        int index = arr.length - 1;
        // 3.把这个密码拆分成每一位数字
        while (number > 0) {
            arr[index] = number % 10;
            number = number / 10;
            index--;
        }
        return arr;
    }

    public static void reverse(int[] arr) {
        // 1.定义两个变量,分别记录数组的头和尾
        int start = 0;
        int end = arr.length - 1;
        // 2.开始交换
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
