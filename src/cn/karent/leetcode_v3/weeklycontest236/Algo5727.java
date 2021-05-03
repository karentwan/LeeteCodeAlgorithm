package cn.karent.leetcode_v3.weeklycontest236;

import java.util.*;

/**
 * 找出游戏的获胜者
 * (约瑟夫环)
 * @author wan
 * @date 2021.04.11
 */
public class Algo5727 {

    public int findTheWinner(int n, int k) {
        int p = 0;
        for(int i = 2; i <= n; i++)
        {
            p = (p + k) % i;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        Algo5727 lc = new Algo5727();
        int n = 5;
        int k = 2;
        int ret = lc.findTheWinner(n, k);
        System.out.println(ret);
    }

}
