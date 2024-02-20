package com.itheima;

public class Test5 {
    public static void main(String[] args) {
        // 目标:完成数组拷贝
        // 定义两个数组
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        // 调用方法
        copyArray(src, dest);
        // 遍历dest数组
        for (int i = 0; i < dest.length; i++) {
            System.out.println(dest[i]);
        }
        // 注意:
        // int[] arr_new = arr; // 这种方式是错误的,这种方式是将arr的地址赋值给arr_new
        // 这样arr_new和arr指向的是同一个数组,修改arr_new的值,会影响arr的值
    }

    public static void copyArray(int[] src, int[] dest) {
        // 遍历src数组,将每个元素拷贝到dest数组中
        for (int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }
}
