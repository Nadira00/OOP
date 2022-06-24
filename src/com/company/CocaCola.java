package com.company;

public class CocaCola extends ConveyerBelt implements Data, economics {
    int n;
    int press;
    String time;
    double radius;
    double height;
    double pi = 3.14;
    double v;
    int cnt;
    double cpcty;
    int size;
    int block_number;
    double prices;
    double e;

    public CocaCola(int n, int press, double radius, double height, int cnt, int size) {
        this.n = n;
        this.press = press;
        this.radius = radius;
        this.height = height;
        this.cnt = cnt;
        this.size = size;
    }

    @Override
    public String toString() {
        return "CocaCola{" +
                "n=" + n +
                ", press=" + press +
                ", radius=" + radius +
                ", height=" + height +
                ", cnt=" + cnt +
                ", size=" + size +
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
            time = "2 hours and 15minutes";
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
        v = pi * radius * radius * height;
        System.out.println(v);
    }

    @Override
    public boolean count() {
        if (cnt < 4 && cnt > 8) {
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
    public void getSize() {
        block_number = size / cnt + 1;
    }

    @Override
    public void getPrice() {
        prices = cpcty * block_number * 180;
    }

    @Override
    public void getEfficiency() {
         e = (cpcty / prices) * 100;
    }
}

