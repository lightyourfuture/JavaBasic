package com.itheima.frame;

import com.itheima.bean.Appointment;
import com.itheima.bean.Department;
import com.itheima.bean.Doctor;
import com.itheima.bean.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class HospitalManager {
    // 充当数据库的角色
    private ArrayList<Department> allDepartments = new ArrayList<>();//1、系统需要存储全部科室信息
    private ArrayList<Appointment> appointments = new ArrayList<>();//2、系统需要记录全部的顶约详

    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("====欢迎进入仁爱医院信息管理系统====");
            System.out.println("1、科室管理-添加科室");
            System.out.println("2、科室管理-删除科室");
            System.out.println("3、科室管理-修改科室");
            System.out.println("4、医生管理-录入医生");
            System.out.println("5、医生管理-医生坐诊设置(可设置当天和未来6天的坐诊情况)");
            System.out.println("6、医生管理-展示全部医生的坐诊详情(当前和未来6天的坐诊详情)");
            System.out.println("7、医生管理-挂号预约");
            System.out.println("8、搜索某个医生当前和未来6天内的病人预约详情(展示每天预约病人的具体信息)");
            System.out.println("0、退出系统");
            System.out.println("请输入操作命令:");
            Scanner sc = new Scanner(System.in);
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    deleteDepartment();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    addDoctor();
                    break;
                case 5:
                    setDoctorJob();
                    break;
                case 6:
                    showAllDoctorInfos();
                    break;
                case 7:
                    appointment();
                    break;
                case 8:
                    searchAppointment();
                    break;
                case 0:
                    System.out.println("感谢使用，欢迎下次再来");
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }

        }
    }

    //添加科室
    private void addDepartment() {
        System.out.println("========添加科室========");
        OUT:
        while (true) {
            System.out.println("请您输入科室名称:");
            String name = sc.next();
            for (int i = 0; i < allDepartments.size(); i++) {
                Department department = allDepartments.get(i);
                if (department.getName().equals(name)) {
                    System.out.println("科室已存在，请重新输入");
                    continue OUT;
                }
            }
            Department department = new Department();
            department.setName(name);
            allDepartments.add(department);
            System.out.println("添加成功");
            break;
        }
    }


    //删除科室
    private void deleteDepartment() {
        System.out.println("========删除科室========");
        System.out.println("请输入要删除的科室名称:");
        String name = sc.next();
        for (int i = 0; i < allDepartments.size(); i++) {
            Department department = allDepartments.get(i);
            if (department.getName().equals(name)) {
                allDepartments.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("没有找到该科室");
    }

    //修改科室
    private void updateDepartment() {
        System.out.println("========修改科室========");
        System.out.println("请输入要修改的科室名称:");
        String name = sc.next();
        for (int i = 0; i < allDepartments.size(); i++) {
            Department department = allDepartments.get(i);
            if (department.getName().equals(name)) {
                System.out.println("请输入新的科室名称:");
                String newName = sc.next();
                // 新旧科室名称不能相同
                if (newName.equals(name)) {
                    System.out.println("新旧科室名称不能相同");
                    return;
                } else if (newName.equals("")) {
                    System.out.println("科室名称不能为空");
                    return;
                } else {
                    // 判断新名称是否存在
                    for (int j = 0; j < allDepartments.size(); j++) {
                        Department department1 = allDepartments.get(j);
                        if (department1.getName().equals(newName)) {
                            System.out.println("新名称已存在");
                            return;
                        }
                    }
                    department.setName(newName);
                    System.out.println("修改成功");
                    return;
                }
            }
        }
        System.out.println("没有找到该科室");
    }

    private Department getDepartmentByUser() {
        if (allDepartments.size() == 0) {
            System.out.println("没有科室信息，请先添加科室");
            return null;
        }
        while (true) {
            System.out.println("请选择科室");
            for (int i = 0; i < allDepartments.size(); i++) {
                Department department = allDepartments.get(i);
                System.out.println((i + 1) + "、" + department.getName());
            }
            System.out.println("请输入科室编号:");
            int departmentIndex = sc.nextInt();
            if (departmentIndex < 1 || departmentIndex > allDepartments.size()) {
                System.out.println("输入错误，请重新输入");
                continue;
            }
            return allDepartments.get(departmentIndex - 1);
        }
    }

    //录入医生
    private void addDoctor() {
        System.out.println("========录入医生========");
        Doctor doctor = new Doctor();
        while (true) {
            Department department = getDepartmentByUser();
            doctor.setDepartmentName(department.getName());
            // 录入医生id
            doctor.setDoctorId(UUID.randomUUID().toString());// 随机生成医生id
            // 录入医生姓名
            System.out.println("请输入医生姓名:");
            doctor.setName(sc.next());
            // 录入医生性别
            System.out.println("请输入医生性别:");
            doctor.setGender(sc.next());
            // 录入医生年龄
            System.out.println("请输入医生年龄:");
            doctor.setAge(sc.nextInt());
            // 录入医生主治方向
            System.out.println("请输入医生主治方向:");
            doctor.setSpecialty(sc.next());
            // 录入医生入职时间
            System.out.println("请输入医生入职时间(格式:yyyy-MM-dd):");
            doctor.setJoinDate(LocalDate.parse(sc.next()));
            // 添加到科室
            department.getDoctors().add(doctor);
            System.out.println("添加成功");
            break;
        }


    }

    //医生坐诊设置
    private void setDoctorJob() {
        System.out.println("========医生坐诊设置========");
        Department department = getDepartmentByUser();
        if (department.getDoctors().size() == 0) {
            System.out.println("该科室没有医生信息，请先添加医生");
            return;
        }
        while (true) {
            System.out.println("当前科室的医生信息如下:");
            for (int i = 0; i < department.getDoctors().size(); i++) {
                Doctor doctor = department.getDoctors().get(i);
                System.out.println((i + 1) + "、" + doctor.getName());
            }
            System.out.println("请输入医生编号:");
            int doctorIndex = sc.nextInt();
            if (doctorIndex < 1 || doctorIndex > department.getDoctors().size()) {
                System.out.println("输入错误，请重新输入");
                continue;
            }
            Doctor doctor = department.getDoctors().get(doctorIndex - 1);
            // 录入坐诊日期
            ArrayList<Schedule> schedules = doctor.getSchedules();
            // 更新未来7天时间
            updateSchedules(schedules);

            // 修改坐诊信息,一次展示这个医生的坐诊详情
            for (int i = 0; i < schedules.size(); i++) {
                Schedule schedule = schedules.get(i);
                updateDoctorSchedule(schedule);
            }
            break;

        }
    }

    //展示全部医生的坐诊详情
    private void showAllDoctorInfos() {
        System.out.println("========展示全部医生的坐诊详情========");
        for (int i = 0; i < allDepartments.size(); i++) {
            Department department = allDepartments.get(i);
            System.out.println(department.getName() + "的医生信息如下:");
            System.out.println("------------------------------------");
            ArrayList<Doctor> doctors = department.getDoctors();
            for (int j = 0; j < doctors.size(); j++) {
                Doctor doctor = doctors.get(j);
                System.out.println(doctor.getName() + "的医生坐班信息如下:");
                ArrayList<Schedule> schedules = doctor.getSchedules();
                updateSchedules(schedules);// 更新未来7天的坐诊信息
                for (int k = 0; k < schedules.size(); k++) {
                    Schedule schedule = schedules.get(k);
                    System.out.println(schedule.getToday() + "的坐诊信息如下:");
                    if (!schedule.isUpdate()) {
                        System.out.println("未排班");
                        continue;
                    }
                    if (schedule.isMorning()) {
                        System.out.println("上午坐诊时间为:" + schedule.getMstart() + "-" + schedule.getMend() + "总数/预约数:" + schedule.getmTotalNumber() + "/" + schedule.getaAppointNumber());
                    } else {
                        System.out.println("上午未排班");
                    }
                    if (schedule.isAfternoon()) {
                        System.out.println("下午坐诊时间为:" + schedule.getAstart() + "-" + schedule.getAend() + "总数/预约数:" + schedule.getaTotalNumber() + "/" + schedule.getaAppointNumber());
                    } else {
                        System.out.println("下午未排班");
                    }
                }
                System.out.println("------------------------------------");
            }
        }
    }

    //挂号预约
    private void appointment() {

    }

    //搜索某个医生当前和未来6天内的病人预约详情
    private void searchAppointment() {

    }

    //更新当前到未来6天的坐诊信息
    private void updateSchedules(ArrayList<Schedule> schedules) {
        if (schedules.size() == 0) {
            for (int i = 0; i < 7; i++) {
                Schedule schedule = new Schedule();
                schedule.setToday(LocalDate.now().plusDays(i));
                schedules.add(schedule);
            }
            return;
        }
        // 除去过期的时间
        for (int i = 0; i < schedules.size(); i++) {
            Schedule schedule = schedules.get(i);
            LocalDate now = LocalDate.now();
            LocalDate currant = schedule.getToday();
            if (currant.equals(now)) {
                break;
            }
            if (currant.isBefore(now)) {
                schedules.remove(schedule);
                i--;
            }
        }
        // 补充未来的时间
        LocalDate last = schedules.get(schedules.size() - 1).getToday();
        int size = schedules.size();
        for (int i = 0; i < 7 - size; i++) {
            Schedule schedule = new Schedule();
            schedule.setToday(last.plusDays(i + 1));
            schedules.add(schedule);
        }
    }

    //更新医生的坐诊信息
    private void updateDoctorSchedule(Schedule schedule) {
        LocalDate today = schedule.getToday();
        System.out.println(today + "的安排如下:");
        if (!schedule.isUpdate()) {
            System.out.println("未排班");
        } else {
            System.out.println("上午");
            if (schedule.isMorning()) {
                System.out.println("坐诊时间为:" + schedule.getMstart() + "-" + schedule.getMend() + "总数/预约数:" + schedule.getmTotalNumber() + "/" + schedule.getaAppointNumber());
            } else {
                System.out.println("未排班");
            }
            System.out.println("下午");
            if (schedule.isAfternoon()) {
                System.out.println("坐诊时间为:" + schedule.getAstart() + "-" + schedule.getAend() + "总数/预约数:" + schedule.getaTotalNumber() + "/" + schedule.getaAppointNumber());
            } else {
                System.out.println("未排班");
            }
        }
        System.out.println("是否修改坐诊信息(y/n):");
        String command = sc.next();
        if (command.equals("y")) {
            schedule.setUpdate(true);// 表示开始了排班了
            System.out.println("是否排班上午(y/n):");
            String morning = sc.next();
            if (morning.equals("y")) {
                schedule.setMorning(true);
                System.out.println("请输入上午坐诊时间(格式:HH:mm)");
                System.out.println("请输入上午坐诊开始时间(格式:HH:mm):");
                schedule.setMstart(LocalTime.parse(sc.next()));
                System.out.println("请输入上午坐诊结束时间(格式:HH:mm):");
                schedule.setMend(LocalTime.parse(sc.next()));
                System.out.println("请输入上午总数:");
                schedule.setmTotalNumber(sc.nextInt());
                System.out.println("请输入上午可预约人数:");
                schedule.setaAppointNumber(sc.nextInt());
            } else {
                schedule.setMorning(false);
            }
            System.out.println("是否排班下午(y/n):");
            String afternoon = sc.next();
            if (afternoon.equals("y")) {
                schedule.setAfternoon(true);
                System.out.println("请输入下午坐诊时间(格式:HH:mm)");
                System.out.println("请输入下午坐诊开始时间(格式:HH:mm):");
                schedule.setAstart(LocalTime.parse(sc.next()));
                System.out.println("请输入下午坐诊结束时间(格式:HH:mm):");
                schedule.setAend(LocalTime.parse(sc.next()));
                System.out.println("请输入下午总数:");
                schedule.setaTotalNumber(sc.nextInt());
                System.out.println("请输入下午可预约人数:");
                schedule.setaAppointNumber(sc.nextInt());
            } else {
                schedule.setAfternoon(false);
            }
        }
    }
}
