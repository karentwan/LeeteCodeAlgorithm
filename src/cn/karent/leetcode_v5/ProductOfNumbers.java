package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 最后k个数的乘积
 * @author wan
 * @date 2021.06.03
 ********************************************/
public class ProductOfNumbers {

    private int[] pds = new int[40010];

    private int idx = 0;

    public ProductOfNumbers() {
        pds[0] = 1;
    }

    public void add(int num) {
        if( num == 0) idx = 0;
        else {
            int next = idx + 1;
            pds[next] = pds[idx] * num;
            idx = next;
        }
    }

    public int getProduct(int k) {
        if( idx < k) return 0;
        return pds[idx] / pds[idx - k];
    }

    public static void main(String[] args) {
        ProductOfNumbers lc = new ProductOfNumbers();
        lc.add(3);
        lc.add(0);
        lc.add(2);
        lc.add(5);
        lc.add(4);
        System.out.println(lc.getProduct(2));
        System.out.println(lc.getProduct(3));
        System.out.println(lc.getProduct(4));
    }

}
