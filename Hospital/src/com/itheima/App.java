package com.itheima;

import com.itheima.frame.HospitalManager;

public class App {
    public static void main(String[] args) {
        // 1、创建医院管理对象
        HospitalManager h = new HospitalManager();
        // 2、调用医院管理对象的start方法
        h.start();
    }
}
