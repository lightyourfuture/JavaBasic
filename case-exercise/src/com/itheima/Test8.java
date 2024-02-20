package com.itheima;

public class Test8 {
    public static void main(String[] args) {
        // 打印9*9乘法表
        printMultiplicationTable();
    }

    public static void printMultiplicationTable() {
        // 定义一个for循环,控制行数
        for (int i = 1; i <= 9; i++) {
            // 定义一个for循环,控制列数
            for (int j = 1; j <= i; j++) {
                // 打印乘法表达式
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            // 换行
            System.out.println();
        }
    }
}
