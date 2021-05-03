package cn.karent.leetcode_v2;

import java.util.*;

import cn.karent.util.*;


/**
 * 去掉最低工资和最高工资后的工资平均值
 * @author wan
 * @date 2021.04.04
 */
public class LeetCode1491 {

    public double average(int[] salary) {
        Arrays.sort(salary);
        int i = 1;
        double average = 0;
        for (; i < salary.length-1; i++) {
            average += salary[i];
        }
        return average / (salary.length - 2);
    }

    public static void main(String[] args) {
        int[] salary = {4000,3000,1000,2000};
        LeetCode1491 lc = new LeetCode1491();
        double ret = lc.average(salary);
        System.out.println(ret);
    }

}
