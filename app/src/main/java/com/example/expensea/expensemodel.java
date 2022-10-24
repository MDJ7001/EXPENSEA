package com.example.expensea;


public class expensemodel {
    private String type;
    private int amt;
    private String day;
    private int dayno;
    private int monthday;
    private int yearday;

    @Override
    public String toString() {
        return "expensemodel{" +
                "type='" + type + '\'' +
                ", amt=" + amt +
                ", day='" + day + '\'' +
                ", dayno=" + dayno +
                ", monthday=" + monthday +
                ", yearday=" + yearday +
                '}';
    }

    public expensemodel(String type, int amt, String day, int dayno, int monthday, int yearday) {
        this.type = type;
        this.amt = amt;
        this.day = day;
        this.dayno = dayno;
        this.monthday = monthday;
        this.yearday = yearday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getDayno() {
        return dayno;
    }

    public void setDayno(int dayno) {
        this.dayno = dayno;
    }

    public int getMonthday() {
        return monthday;
    }

    public void setMonthday(int monthday) {
        this.monthday = monthday;
    }

    public int getYearday() {
        return yearday;
    }

    public void setYearday(int yearday) {
        this.yearday = yearday;
    }
}