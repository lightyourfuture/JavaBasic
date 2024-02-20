package com.itheima.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private LocalDate today;// 今天
    private boolean update;// 是否修改,默认未排班
    // 上午
    private boolean morning;// 是否看诊
    private LocalTime mstart;// 上午看诊开始时间
    private LocalTime mend;// 上午看诊结束时间
    private int mTotalNumber;// 上午能接诊总人数
    private int mAppointNumbe;// 上午预约号数

    // 下午
    private boolean afternoon;// 是否看诊
    private LocalTime astart;// 下午看诊开始时间
    private LocalTime aend;// 下午看诊结束时间
    private int aTotalNumber;// 下午能接诊总人数
    private int aAppointNumber;// 下午预约号数

    public Schedule() {// 无参构造
    }

    public Schedule(LocalDate today, boolean update, boolean morning, LocalTime mstart, LocalTime mend, int mTotalNumber, int mAppointNumbe, boolean afternoon, LocalTime astart, LocalTime aend, int aTotalNumber, int aAppointNumber) {
        // 有参构造
        this.today = today;
        this.update = update;
        this.morning = morning;
        this.mstart = mstart;
        this.mend = mend;
        this.mTotalNumber = mTotalNumber;
        this.mAppointNumbe = mAppointNumbe;
        this.afternoon = afternoon;
        this.astart = astart;
        this.aend = aend;
        this.aTotalNumber = aTotalNumber;
        this.aAppointNumber = aAppointNumber;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isMorning() {
        return morning;
    }

    public void setMorning(boolean morning) {
        this.morning = morning;
    }

    public LocalTime getMstart() {
        return mstart;
    }

    public void setMstart(LocalTime mstart) {
        this.mstart = mstart;
    }

    public LocalTime getMend() {
        return mend;
    }

    public void setMend(LocalTime mend) {
        this.mend = mend;
    }

    public int getmTotalNumber() {
        return mTotalNumber;
    }

    public void setmTotalNumber(int mTotalNumber) {
        this.mTotalNumber = mTotalNumber;
    }

    public int getmAppointNumbe() {
        return mAppointNumbe;
    }

    public void setmAppointNumbe(int mAppointNumbe) {
        this.mAppointNumbe = mAppointNumbe;
    }

    public boolean isAfternoon() {
        return afternoon;
    }

    public void setAfternoon(boolean afternoon) {
        this.afternoon = afternoon;
    }

    public LocalTime getAstart() {
        return astart;
    }

    public void setAstart(LocalTime astart) {
        this.astart = astart;
    }

    public LocalTime getAend() {
        return aend;
    }

    public void setAend(LocalTime aend) {
        this.aend = aend;
    }

    public int getaTotalNumber() {
        return aTotalNumber;
    }

    public void setaTotalNumber(int aTotalNumber) {
        this.aTotalNumber = aTotalNumber;
    }

    public int getaAppointNumber() {
        return aAppointNumber;
    }

    public void setaAppointNumber(int aAppointNumber) {
        this.aAppointNumber = aAppointNumber;
    }
}
