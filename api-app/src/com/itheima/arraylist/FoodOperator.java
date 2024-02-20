package com.itheima.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

// 菜品操作类,负责对菜品上架和浏览功能的实现
public class FoodOperator {
    // 定义一个ArrayList集合,用于存储菜品对象
    private ArrayList<Food> foodlist = new ArrayList<>();

    // 定义一个方法,上架菜品
    public void addFood() {
        Food food = new Food();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入菜品名称");
        String name = sc.next();
        food.setName(name);

        System.out.println("请输入菜品价格");
        double price = sc.nextDouble();
        food.setPrice(price);

        System.out.println("请输入菜品描述");
        String desc = sc.next();
        food.setDesc(desc);

        foodlist.add(food);
        System.out.println("菜品上架成功");
    }

    // 定义一个方法,浏览菜品
    public void showAllFood() {
        if (foodlist.size() == 0) {
            System.out.println("暂无菜品信息,请先上架菜品");
            return;
        }
        System.out.println("菜品名称\t菜品价格\t菜品描述");
        for (int i = 0; i < foodlist.size(); i++) {
            Food food = foodlist.get(i);
            System.out.println(food.getName() + "\t" + food.getPrice() + "\t" + food.getDesc());
        }
    }

    // 负责展示操作界面
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎使用点餐系统");
            System.out.println("1.上架菜品 2.浏览菜品 3.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    System.out.println("上架菜品");
                    addFood();
                    break;
                case "2":
                    System.out.println("浏览菜品");
                    showAllFood();
                    break;
                case "3":
                    System.out.println("谢谢使用");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误,请重新输入");
                    break;
            }
        }
    }
}
