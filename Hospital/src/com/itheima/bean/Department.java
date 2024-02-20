package com.itheima.bean;

import java.util.ArrayList;

// 科室类
public class Department {
    private String name;// 科室名称
    private ArrayList<Doctor> doctors = new ArrayList<>();// 包含的医生

    public Department() {// 无参构造
    }

    public Department(String name, ArrayList<Doctor> doctors) {
        // 有参构造
        this.name = name;
        this.doctors = doctors;
    }

    // get set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    // 返回医生数量
    public int getNumber() {
        return doctors.size();
    }
}
