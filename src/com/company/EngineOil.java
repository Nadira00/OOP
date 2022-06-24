package com.company;

public class EngineOil extends ConveyerBelt implements Data, economics {
    int n;
    int press;
    String time;
    double length;
    double width;
    double height;
    double v;
    int cnt;
    double cpcty;
    int size;
    int block_number;
    double prices;
    double e;

    public EngineOil(int n, int press, double length, double width, double height, int cnt, int size) {
        this.n = n;
        this.press = press;
        this.length = length;
        this.width = width;
        this.height = height;
        this.cnt = cnt;
        this.size = size;
    }
    @Override
    public String toString() {
        return "EngineOil{" +
                "n=" + n +
                ", press=" + press +
                ", length=" + length +
                ", width=" + width +
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
            time = "3 hours and 25 minutes";
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
        if (cnt < 3 && cnt > 6) {
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
        prices = cpcty * block_number * 600;
    }

    @Override
    public void getEfficiency() {
        e = (cpcty / prices) * 100;
    }
}
