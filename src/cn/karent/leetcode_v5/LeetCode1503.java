package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 两只蚂蚁同时改变方向相当于两只蚂蚁同时都不改变方向
 * @author wan
 * @date 2021.06.04
 ********************************************/
public class LeetCode1503 {

    public int getLastMoment(int n, int[] left, int[] right) {
        int ret = 0;
        for (int item : left) {
            ret = Math.max(ret, item);
        }
        for (int item : right) {
            ret = Math.max(ret, n - item);
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
