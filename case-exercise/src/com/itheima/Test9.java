package com.itheima;

import java.util.Scanner;

public class Test9 {
    public static void main(String[] args) {
        int[] userNumbers = userSelectNumbers();
        int[] luckyNumbers = createLuckNumbers();
        judge(userNumbers, luckyNumbers);
    }

    // 1.用于让用户投注一组号码(前6个是红球,后1个是蓝球)，并返回用户投注的号码
    public static int[] userSelectNumbers() {
        // 2.创建一个整型数组,用于存储用户投注的7个号码(前6个是红球,后1个是蓝球)
        int[] numbers = new int[7];
        Scanner sc = new Scanner(System.in);
        // 3.遍历前6个红球号码，让用户一次投注6个红球号码，存入
        for (int i = 0; i < numbers.length - 1; i++) {
            while (true) {
                // 4.开始让用户为当前没位置投注一个红球号码(1-33之间,不能重复)
                System.out.println("请输入第" + (i + 1) + "个红球号码(1-33之间,不能重复):");
                int number = new Scanner(System.in).nextInt();

                // 5.判断用户输入的红球号码是否合法
                if (number < 1 || number > 33) {
                    // 6.如果不合法,则提示用户重新输入
                    System.out.println("您输入的红球号码不在1-33之间,请重新输入!");
                } else {
                    // 号码虽然在1-33之间，接着还要看是否重复，不重复才可以使用
                    if (exist(numbers, number)) {
                        // number当前这个红球号码是重复了
                        System.out.println("您输入的红球号码已经存在,请重新输入!");
                    } else {
                        // 7.如果合法,则将用户输入的红球号码存入数组
                        numbers[i] = number;
                        // 8.如果合法,则结束循环
                        break;
                    }
                }
            }
        }
        // 9.让用户投注一个蓝球号码(1-16之间)
        while (true) {
            // 10.开始让用户投注一个蓝球号码(1-16之间)
            System.out.println("请输入蓝球号码(1-16之间):");
            int number = new Scanner(System.in).nextInt();
            // 11.判断用户输入的蓝球号码是否合法
            if (number < 1 || number > 16) {
                // 12.如果不合法,则提示用户重新输入
                System.out.println("您输入的蓝球号码不在1-16之间,请重新输入!");
            } else {
                // 13.如果合法,则将用户输入的蓝球号码存入数组
                numbers[6] = number;
                // 14.如果合法,则结束循环
                break;
            }
        }
        return numbers;
    }

    // 2.系统随机一组中奖号码(前6个是红球,后1个是蓝球)，并返回中奖号码
    public static int[] createLuckNumbers() {
        // 1.创建一个整型数组,用于存储中奖号码(前6个是红球,后1个是蓝球)
        int[] luckyNumbers = new int[7];
        // 2.使用for循环,随机生成7个号码
        for (int i = 0; i < luckyNumbers.length - 1; i++) {
            // 3.使用Math类的random()方法,生成一个随机数(1-33)
            luckyNumbers[i] = (int) (Math.random() * 33) + 1;
        }
        // 4.使用Math类的random()方法,生成一个随机数(1-16)
        luckyNumbers[6] = (int) (Math.random() * 16) + 1;
        // 5.返回中奖号码
        return luckyNumbers;
    }

    // 3.判断用户是否中奖
    public static void judge(int[] userNumbers, int[] luckyNumbers) {
        // 1.使用for循环,遍历用户投注的6个红球号码
        for (int i = 0; i < userNumbers.length - 1; i++) {
            // 2.使用if语句,判断用户投注的红球号码是否中奖
            if (userNumbers[i] == luckyNumbers[i]) {
                // 3.如果中奖,则输出中奖信息
                System.out.println("恭喜您,中了一等奖!");
                // 4.如果中奖,则结束方法
                return;
            }
        }
        // 5.使用if语句,判断用户投注的蓝球号码是否中奖
        if (userNumbers[6] == luckyNumbers[6]) {
            // 6.如果中奖,则输出中奖信息
            System.out.println("恭喜您,中了二等奖!");
        } else {
            // 7.如果不中奖,则输出不中奖信息
            System.out.println("很遗憾,您没有中奖!");
        }
    }

    public static boolean exist(int[] numbers, int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return true;
            }
        }
        return false;

    }
}
