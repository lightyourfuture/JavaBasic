package com.itheima;

public class Test7 {
    public static void main(String[] args) {
        // 目标:寻找两个数字之间的素数
        System.out.println("请输入开始的数字");
        int start = new java.util.Scanner(System.in).nextInt();
        System.out.println("请输入结束的数字");
        int end = new java.util.Scanner(System.in).nextInt();
        findPrimeNumber(start, end);
    }

    public static void findPrimeNumber(int start, int end) {
        // 定义一个for循环,遍历start到end之间的所有数字
        for (int i = start; i <= end; i++) {
            // 定义一个变量,记录i的因数个数
            int count = 0;
            // 定义一个for循环,遍历1到i之间的所有数字
            for (int j = 1; j <= i; j++) {
                // 判断i能否被j整除
                if (i % j == 0) {
                    count++;
                }
            }
            // 判断count的值是否为2
            if (count == 2) {
                // 将i打印到控制台
                System.out.println(i);
            }
        }
    }
}
