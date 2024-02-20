package com.itheima;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        // 目标:完成评委打分的案例
        double avg = getAverage(5);
        System.out.println("最终得分:" + avg);
    }

    public static double getAverage(int number) {
        // 1.定义一个动态初始化的数组,用于存储评委的分数
        int[] arr = new int[number];
        // 2.遍历数组,键盘录入评委的分数
        // 3.定义一个变量用于记录总分
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            // 4.键盘录入评委的分数
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入第" + (i + 1) + "个评委的分数:");
            arr[i] = sc.nextInt();
            // 5.累加总分
            sum += arr[i];
        }
        // 6.求出最高分和最低分
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 7.求出总分减去最高分和最低分的平均分
        sum = sum - max - min;
        sum = sum / (arr.length - 2);
        // 8.返回平均分
        return sum;

    }
}
