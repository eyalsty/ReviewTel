package com.example.springboot.model;

public class GeneralObjWithAvg {
    private String name;
    private double avg;
    public GeneralObjWithAvg()
    {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getAvg() {
        return avg;
    }
    public void convert(Object[] object)
    {
        name = (String) object[0];
        avg = (double) object[1];
        twoDigitForDouble();
    }
    private void twoDigitForDouble()
    {
        avg = avg*10;
        int temp = (int)avg;
        avg = (double)temp/10;
    }

}