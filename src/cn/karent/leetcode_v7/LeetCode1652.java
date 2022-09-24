package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;

import java.util.*;

/******************************************
 * 拆炸弹
 * @author wan
 * @date 2022.09.24 09:51
 ******************************************/
public class LeetCode1652 {

    public int[] decrypt(int[] code, int k) {
        int size = code.length;
        int[] preSum = new int[size +1];
        for (int i = 1; i <= size; i++) {
            preSum[i] += preSum[i-1] + code[i-1];
        }
        int[] rets = new int[size];
        for (int i = 0; i < rets.length; i++) {
            if (k == 0) {
                rets[i] = 0;
            } else if (k > 0) {
                int up = i + k;
                int idx1 = up >= size ? size : up + 1;
                int idx2 = up >= size ? (up % size) + 1 : 0;
                rets[i] = preSum[idx1] - preSum[i+1] + preSum[idx2];
            } else {
                int down = i + k;
                int idx1 = Math.max(down, 0);
                int idx2 = down < 0 ? (down + size) % size : size;
                rets[i] = preSum[i] - preSum[idx1] + preSum[size] - preSum[idx2];
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1652 lc = new LeetCode1652();
//        int[] code = {5,7,1,4};
//        int k = 3;
        int[] code = {2,4,9,3};
        int k = -2;
        int[] rets = lc.decrypt(code, k);
        LeetCodeUtil.print(rets);
    }

}
