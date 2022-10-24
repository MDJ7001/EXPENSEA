package com.example.expensea;

public class tripmodel {
    private String name;
    private int amt;


    public tripmodel(String name, int amt) {

        this.name = name;
        this.amt = amt;

    }

    @Override
    public String toString() {
        return "tripmodel{" +
                "name='" + name + '\'' +
                ", amt=" + amt +
                '}';
    }




    public String getType() {
        return name;
    }

    public void setType(String type) {
        this.name = type;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }

}
