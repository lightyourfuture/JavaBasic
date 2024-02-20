package com.itheima;

public class Account {
    private String cardId;// 卡号
    private String userName;// 姓名
    private char sex;// 性别
    private String passWord;// 密码
    private double money;// 余额
    private double limit;// 每次取现额度

    public Account() {
    }

    public Account(String cardId, String userName, char sex, String passWord, double money, double limit) {
        this.cardId = cardId;
        this.userName = userName;
        this.sex = sex;
        this.passWord = passWord;
        this.money = money;
        this.limit = limit;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
