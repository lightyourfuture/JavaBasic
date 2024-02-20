package com.itheima.arraylist;
import java.util.ArrayList;
/**
 * 目标:账务从集合容器中找数据并删除的技巧
 * list.add("Java入门");
 * list.add("宁夏枸杞");
 * list.add("黑枸杞");
 * list.add("人字拖");
 * list.add("特级枸杞");
 * list.add("枸杞子");
 */
public class ArrayListTest2 {
    public static void main(String[] args) {
        // 1.创建一个ArrayList集合对象
        ArrayList<String> list = new ArrayList<>();
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        System.out.println(list);//[Java入门, 宁夏枸杞, 黑枸杞, 人字拖, 特级枸杞, 枸杞子]

        // 2.开始完成需求:删除集合中所有的枸杞相关的元素
        for (int i = 0; i < list.size(); i++) {
            String ele= list.get(i);
            // 判断当前元素是否包含枸杞
            if(ele.contains("枸杞")) {
                list.remove(ele);
                i--;// 注意:删除一个元素后，索引i要减1
            }
        }
        System.out.println(list);//[Java入门, 人字拖]

    }
}
