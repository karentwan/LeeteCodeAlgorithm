package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 4的幂
 * @author wan
 * @date 2021.05.31
 ********************************************/
public class LeetCode342 {

    public boolean isPowerOfFour(int n) {
        if( n <= 0) return false;
        if( (n & ( n - 1)) == 0 && (n & 0xaaaaaaaa) == 0) return true;
        return false;
    }

    public static void main(String[] args) {

    }

}
