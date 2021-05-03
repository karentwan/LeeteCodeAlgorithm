package cn.karent.leetcode_v1;

/**
 * 设计停车系统
 */
public class ParkingSystem {

    private int big;

    private int medium;

    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        boolean ret = false;
        switch (carType) {
            case 1:
                if( big > 0) {
                    big--;
                    ret = true;
                }
                break;
            case 2:
                if( medium > 0) {
                    medium--;
                    ret = true;
                }
                break;
            case 3:
                if( small > 0) {
                    small--;
                    ret = true;
                }
                break;
        }
        return ret;
    }

}
