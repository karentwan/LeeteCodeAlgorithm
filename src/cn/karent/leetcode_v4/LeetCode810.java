package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 黑板异或游戏
 * @author wan
 * @date 2021.05.22
 ********************************************/
public class LeetCode810 {

    public boolean xorGame(int[] nums) {
        if( nums.length % 2 == 0) return true;
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor == 0;
    }

    public static void main(String[] args) {

    }

}
