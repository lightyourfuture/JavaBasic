package com.itheima;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        // 目标:完成生成随机验证码的案例
        String code = createCode(5);// 生成5位随机字符
        System.out.println("验证码:" + code);
    }

    public static String createCode(int n) {
        // 生成n位随机字符
        // 1.定义一个for循环用于控制产生多少位随机字符
        Random r = new Random();// 创建一个随机数对象
        // 3.定义一个字符串用于拼接随机字符
        String code = "";
        for (int i = 1; i <= n; i++) {
            // 2.为没个位置生成一个随机字符:可能是数字,大小写字母
            // 思路:随机一个0 1 2之间的数字出来,根据数字生成对应的字符
            // 0:数字  1:大写字母  2:小写字母
            // 生成一个0-2之间的随机数
            int type = r.nextInt(3);
            switch (type) {
                case 0:
                    // 数字
                    code += r.nextInt(10);
                    break;
                case 1:
                    // 大写字母
                    // 生成一个65-90之间的随机数
                    code += (char) (r.nextInt(26) + 65);
                    break;
                case 2:
                    // 小写字母
                    // 生成一个97-122之间的随机数
                    code += (char) (r.nextInt(26) + 97);
                    break;
            }
        }
        return code;
    }
}
// 代码解析:
// 1.定义一个for循环用于控制产生多少位随机字符
// 2.为没个位置生成一个随机字符:可能是数字,大小写字母
// 思路:随机一个0 1 2之间的数字出来,根据数字生成对应的字符
// 0:数字  1:大写字母  2:小写字母
// 3.定义一个字符串用于拼接随机字符
// 4.返回拼接好的字符串
// 5.在main方法中调用createCode方法,传入5,生成5位随机字符,并打印输出

