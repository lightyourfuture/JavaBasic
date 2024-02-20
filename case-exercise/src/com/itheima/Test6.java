package com.itheima;

import java.util.Random;
import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {
        // 目标: 完成抢红包案例
        // 定义一个数组,存储5个金额
        int[] moneys = {1, 2, 3, 4, 5};
        // 调用方法
        start(moneys);

    }

    public static void start(int[] moneys) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        // 定义一个for循环,控制抽奖5次
        for (int i = 1; i <= 5; i++) {
            // 提示用户抽奖
            System.out.println("请您输入任意内容进行抽奖");
            sc.next(); // 接收用户输入的内容
            while (true) {
                // 生成随机数
                int index = r.nextInt(moneys.length);// 0-4
                // 根据随机数,从数组中获取金额
                int money = moneys[index];
                // 判断金额是否为0
                if (money != 0) {
                    // 将金额打印到控制台
                    System.out.println("恭喜您抽中了" + money + "元");
                    // 将数组中的金额置为0
                    moneys[index] = 0;
                    break;// 结束这次抽奖
                }
            }
        }
        System.out.println("抽奖结束");
    }
}
