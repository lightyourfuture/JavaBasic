package com.itheima.string;

import java.util.Scanner;

public class StringTest4 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            // 1.开发一个登录界面
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名:");
            String username = sc.nextLine();
            System.out.println("请输入密码:");
            String password = sc.nextLine();

            // 3.调用登录方法
            boolean flag = login(username, password);
            if (flag) {
                System.out.println("登录成功");
                break;
            } else {
                System.out.println("登录失败");
            }
            if (i == 2) {
                System.out.println("最多输入3次，已退出程序");
            }
        }

    }

    public static boolean login(String username, String password) {
        // 2.判断用户名和密码是否正确
        // 正确的用户名和密码分别是itheima和czbk
        // 不要使用==判断字符串是否相等
        // if (username == "itheima" && password == "czbk") {
        //     System.out.println("登录成功");
        // } else {
        //     System.out.println("用户名或密码错误");
        // }
        // 这比较的是地址值，不是内容
        // 应该调用String类的equals方法
        // if ("itheima".equals(username) && "czbk".equals(password)) {
        //     return true;
        // } else {
        //     return false;
        // }
        return "itheima".equals(username) && "czbk".equals(password);
    }
}
