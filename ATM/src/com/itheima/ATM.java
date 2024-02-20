package com.itheima;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private Scanner sc = new Scanner(System.in);

    // 启动ATM系统,展示欢迎页面
    public void start() {
        while (true) {
            System.out.println("欢迎使用ATM自助服务系统");
            System.out.println("1.用户登陆");
            System.out.println("2.用户开户");
            System.out.println("0.退出");
            System.out.println("请选择操作");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // 用户登陆
                    login();
                    break;
                case 2:
                    // 用户开户
                    creatAccount();
                    break;
                case 0:
                    System.out.println("谢谢使用");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }

    // 用户登陆
    public void login() {
        System.out.println("系统登录");
        if (accounts.size() == 0) {
            System.out.println("当前没有用户");
            return;
        } else {
            Account account = null;
            while (true) {
                System.out.println("请输入卡号");
                String cardId = sc.next();
                account = getAccountByCardId(cardId);
                if (account == null) {
                    System.out.println("卡号输入不存在");
                } else {
                    break;
                }
            }
            while (true) {
                System.out.println("请输入密码");
                String password = sc.next();
                if (account.getPassWord().equals(password)) {
                    System.out.println("登陆成功");
                    System.out.println("您的卡号是" + account.getCardId());
                    showUserCommand(account);
                    return;
                } else {
                    System.out.println("密码输入有误");
                }
            }
        }
    }

    // 展示登录后的操作页面
    private void showUserCommand(Account account) {
        System.out.println("欢迎" + account.getUserName() + "使用ATM自助服务系统");
        while (true) {
            System.out.println("1.查询余额");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销当前账户");
            System.out.println("请选择操作");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    // 展现当前登录的账户信息
                    showAccountInfo(account);
                    break;
                case 2:
                    // 存款
                    deposit(account);
                    break;
                case 3:
                    // 取款
                    withdraw(account);
                    break;
                case 4:
                    // 转账
                    transfer(account);
                    break;
                case 5:
                    // 修改密码
                    changePassword(account);
                    return;
                case 6:
                    // 退出
                    System.out.println(account.getUserName() + "您已退出系统");
                    return;
                case 7:
                    // 注销当前账户
                    if (deleteAccount(account)) {
                        // 注销成功,回到欢迎页面
                        return;
                    }
                    // 注销失败,回到操作页面
                    break;
                default:
                    System.out.println("输入有误");
            }
        }
    }

    // 展现当前登录的账户信息
    private void showAccountInfo(Account account) {
        System.out.println(account.getUserName() + "账户信息");
        System.out.println("卡号:" + account.getCardId());
        System.out.println("姓名:" + account.getUserName());
        System.out.println("性别:" + account.getSex());
        System.out.println("余额:" + account.getMoney());
        System.out.println("每次取现额度:" + account.getLimit());
    }

    // 存款
    private void deposit(Account account) {
        System.out.println("存款");
        double money = 0;
        while (true) {
            System.out.println("请输入存款金额");
            money = sc.nextDouble();
            if (money < 0) {
                System.out.println("存款金额输入不能小于0");
            } else {
                break;
            }
        }
        account.setMoney(account.getMoney() + money);
        System.out.println("存款成功");
        System.out.println("当前余额:" + account.getMoney());
    }

    // 取款
    private void withdraw(Account account) {
        System.out.println("取款");
        double money = 0;
        // 余额大于等于100允许取款
        if (account.getMoney() < 100) {
            System.out.println("余额小于100,不能取款");
            return;
        }
        while (true) {
            System.out.println("当前余额:" + account.getMoney());
            System.out.println("每次取现额度:" + account.getLimit());
            System.out.println("请输入取款金额");
            money = sc.nextDouble();
            if (money < 0) {
                System.out.println("取款金额输入不能小于0");
            } else if (money > account.getMoney()) {
                System.out.println("取款金额不能大于余额");
            } else if (money > account.getLimit()) {
                System.out.println("取款金额不能大于每次取现额度");
            } else if (money < 100) {
                System.out.println("取款金额不能小于100");
            } else {
                break;
            }
        }
        account.setMoney(account.getMoney() - money);
        System.out.println("取款成功");
        System.out.println("当前余额:" + account.getMoney());
    }

    // 转账
    private void transfer(Account account) {
        System.out.println("转账");
        Account otherAccount = null;
        // 自己账户是否有钱
        if (account.getMoney() < 100) {
            System.out.println(account.getUserName() + "余额小于100,不能转账");
            return;
        }
        // 系统总是否有其他账户
        if (accounts.size() == 1) {
            System.out.println("当前没有其他账户,不能转账");
            return;
        }
        while (true) {
            System.out.println("请输入对方卡号");
            String cardId = sc.next();
            otherAccount = getAccountByCardId(cardId);
            if (otherAccount == null) {
                System.out.println("对方卡号不存在");
            } else if (otherAccount == account) {
                System.out.println("不能给自己转账");
            } else {
                // 验证对方账户的户主姓氏
                System.out.println("请输入对方户主姓名");
                String userName = sc.next();
                if (!otherAccount.getUserName().equals(userName)) {
                    System.out.println("户主姓名输入有误");
                } else {
                    System.out.println("对方户主姓名验证成功");
                    break;
                }
            }
        }
        double money = 0;
        while (true) {
            System.out.println("请输入转账金额");
            money = sc.nextDouble();
            if (money < 0) {
                System.out.println("转账金额输入不能小于0");
            } else if (money > account.getMoney()) {
                System.out.println("转账金额不能大于余额");
            } else {
                break;
            }
        }
        System.out.println(account.getUserName() + "转账之前的余额:" + account.getMoney());
        System.out.println(otherAccount.getUserName() + "转账之前的余额:" + otherAccount.getMoney());
        System.out.println("正在转账...");
        account.setMoney(account.getMoney() - money);
        otherAccount.setMoney(otherAccount.getMoney() + money);
        System.out.println("转账成功");
        System.out.println(account.getUserName() + "当前余额:" + account.getMoney());
        System.out.println(otherAccount.getUserName() + "余额:" + otherAccount.getMoney());
    }

    // 修改密码
    private void changePassword(Account account) {
        System.out.println("修改密码");
        while (true) {
            System.out.println("请输入原密码");
            String oldPassword = sc.next();
            if (account.getPassWord().equals(oldPassword)) {
                while (true) {
                    System.out.println("请输入新密码");
                    String newPassword = sc.next();
                    System.out.println("请再次输入新密码");
                    String newPassword2 = sc.next();
                    if (newPassword.equals(newPassword2)) {
                        if (newPassword.equals(oldPassword)) {
                            System.out.println("新密码不能与原密码相同");
                            continue;
                        }
                        account.setPassWord(newPassword);
                        System.out.println("修改密码成功");
                        return;
                    } else {
                        System.out.println("两次密码输入不一致");
                    }
                }
            } else {
                System.out.println("原密码输入有误");
            }
        }
    }

    // 注销当前账户
    private boolean deleteAccount(Account account) {
        // 首先询问是否确定要销户,不确定则回到操作页面
        System.out.println("确定要注销当前账户吗?y/n");
        String choice = sc.next();
        if (choice.equals("y")) {
            // 如果确定,要判断用户的账户中是否有钱,如果有钱,不能销户,并回到操作界面
            if (account.getMoney() > 0) {
                System.out.println("账户中还有余额,不能销户");
                return false;
            }
            // 如果没有钱,可以销户,并回到欢迎页面
            accounts.remove(account);
            System.out.println("注销成功");
            return true;
        } else {
            System.out.println("取消注销");
            return false;
        }

    }

    // 用户开户
    private void creatAccount() {
        System.out.println("开户");
        // 创建一个开户对象,用于封装用户的开户信息
        Account account = new Account();
        // 需要用户输入自己的开户信息,赋值给账户对象
        System.out.println("请输入姓名");
        account.setUserName(sc.next());
        while (true) {
            System.out.println("请输入性别");
            char sex = sc.next().charAt(0);
            if (sex == '男' || sex == '女') {
                account.setSex(sex);
                break;
            } else {
                System.out.println("性别输入有误,只能是男或女");
            }
        }
        while (true) {
            System.out.println("请输入密码");
            String password = sc.next();
            System.out.println("请再次输入密码");
            String password2 = sc.next();
            if (password.equals(password2)) {
                account.setPassWord(password);
                break;
            } else {
                System.out.println("两次密码输入不一致");
            }
        }
        System.out.println("请输入每次取现额度");
        account.setLimit(sc.nextDouble());

        // 生成一个8位数字的卡号
        String cardId = createCardId();
        account.setCardId(cardId);
        // 将账户对象存储到集合中
        accounts.add(account);
        System.out.println("开户成功");
        System.out.println("您的卡号是:" + cardId);
    }

    // 返回一个8位数字的卡号,而且这个卡号不能与其他账户的卡号重复
    private String createCardId() {
        while (true) {
            String cardId = "";
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                int data = r.nextInt(10);
                cardId += data;
            }
            // 判断这个卡号是否已经存在
            if (getAccountByCardId(cardId) == null) {
                return cardId;
            }
        }
    }

    // 判断这个卡号是否已经存在
    private Account getAccountByCardId(String cardId) {
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            // 判断这个账户对象account中的卡号是否是我们要找的卡号
            if (account.getCardId().equals(cardId)) {
                return account;
            }
        }
        return null;
    }
}