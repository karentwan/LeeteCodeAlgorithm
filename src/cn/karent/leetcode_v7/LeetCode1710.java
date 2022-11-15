package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 卡车上的最大单元数
 * @author wan
 * @date 2022.11.15 09:55
 ******************************************/
public class LeetCode1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (k1, k2)-> k2[1] - k1[1]);
        int ret = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int[] boxType = boxTypes[i];
            int n = Math.min(boxType[0], truckSize);
            truckSize -= n;
            ret += boxType[1] * n;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1710 lc = new LeetCode1710();
    }

}
