package com.company;

public class Chocolate extends ConveyerBelt implements Data, alarm {
    int n;
    int press;
    String time;
    double length;
    double width;
    double height;
    double v;
    int cnt;
    double cpcty;
    int alarm_state;

    public Chocolate(int n, int press, double length, double width, double height, int cnt) {
        this.n = n;
        this.press = press;
        this.length = length;
        this.width = width;
        this.height = height;
        this.cnt = cnt;

    }
    @Override
    public String toString() {
        return "Chocolate{" +
                "n=" + n +
                ", press=" + press +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", cnt=" + cnt +
                '}';
    }



    @Override
    public void start() {
        if (press == 1) {
            System.out.println("system started");
        } else if (press == 0) {
            System.out.println("system wasn't started");
        }
    }

    @Override
    public boolean check_existing() {
        if (n == 0) return false;
        else return true;
    }

    @Override
    public void setTime() {
        if (check_existing()) {
            time = "1 hours and 45 minutes";
            System.out.println(time);
        } else {
            time = "0";
            System.out.println(time);
        }
    }


    @Override
    public void stop() {
        if (check_existing() == false) {
            System.out.println("Turn off the conveyer ");
        } else {
            System.out.println("conveyer in progress");
        }
    }



    @Override
    public void volume() {
        v = length*width*height;
        System.out.println(v);
    }

    @Override
    public boolean count() {
        if (cnt < 8 && cnt > 16) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void capacity() {
        cpcty = cnt * v;
        System.out.println(cpcty);
    }

    @Override
    public void priority() {
        if(cpcty >= 10000){
            alarm_state = 3;
            System.out.println("Urgent Priority alarm exists" );
        }
        else if(cpcty < 10000 && cpcty >= 5500 ){
            alarm_state = 2;
            System.out.println("HIGH Priority alarm exists");
        }
        else if(cpcty < 5500 && cpcty >= 2500){
            alarm_state = 1;
            System.out.println("LOW Priority alarm exists");
        }
        else{
            alarm_state = 0;
            System.out.println("System is at the normal state");
        }
    }

    @Override
    public boolean exist() {
        if(alarm_state == 0) return false;
        else return true;
    }


    @Override
    public void acknowledge() {
    if(alarm_state ==3){
        System.out.println("Operator turn off all system");
    }
    else if(alarm_state == 2){
        System.out.println("Operator turn on Emergency Shutdown System");
    }
    else if(alarm_state == 1){
        System.out.println("Operator turn off conveyer belt");
    }
    else {
        System.out.println("Alarm wasn't detected");
    }
    }
}
