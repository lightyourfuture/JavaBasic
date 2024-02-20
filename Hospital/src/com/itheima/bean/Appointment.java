package com.itheima.bean;

import java.time.LocalDateTime;

public class Appointment {
    //包含预约时间、患者信息、所选医生、状态等属性
    private String userName;// 患者姓名
    private char sex;// 患者性别
    private int age;// 患者年龄
    private String tel;// 患者电话
    private String desc;// 病情描述
    private String departName;// 科室名称
    private String doctorId;// 医生编号
    private LocalDateTime appointDateTime;// 预约时间

    public Appointment() {// 无参构造
    }

    public Appointment(String userName, char sex, int age, String tel, String desc, String departName, String doctorId, LocalDateTime appointDateTime) {
        // 有参构造
        this.userName = userName;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.desc = desc;
        this.departName = departName;
        this.doctorId = doctorId;
        this.appointDateTime = appointDateTime;
    }

    // get set方法

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointDateTime() {
        return appointDateTime;
    }

    public void setAppointDateTime(LocalDateTime appointDateTime) {
        this.appointDateTime = appointDateTime;
    }
}
