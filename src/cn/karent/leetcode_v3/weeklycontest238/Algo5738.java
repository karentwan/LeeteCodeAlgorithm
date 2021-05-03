package cn.karent.leetcode_v3.weeklycontest238;

import java.util.*;

/********************************************
 * description: K进制表示下的各位数字和
 * @author wan
 * @date 2021.04.25
 ********************************************/
public class Algo5738 {

    public int sumBase(int n, int k) {
        int ret = 0;
        while (n > 0) {
            ret += n % k;
            n /= k;
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo5738 lc = new Algo5738();
//        int n = 34;
//        int k = 6;
        int n = 10;
        int k = 10;
        int ret = lc.sumBase(n, k);
        System.out.println(ret);
    }

}
