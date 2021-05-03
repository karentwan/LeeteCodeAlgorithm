package cn.karent.util;

import java.util.*;

/**
 * 树状数组
 * @author wan
 * @date 2021.04.11
 */
public class TreeArray {

    private int[] data;

    private int n;

    public TreeArray(int[] arr) {
        n = arr.length + 1;
        // data里面第0个元素不用
        for (int i = 1; i < n; i++) {
            update(i, arr[i-1]);
        }
    }

    /**
     * 获取x的最低以为比特为一的数字, 例如0110, 获得的是0010
     * @param x
     * @return
     */
    public int lowbit(int x) {
        return x & (-x);
    }

    /**
     * 求范围和 A[1]-A[idx]的范围和
     * @param idx
     * @return
     */
    public int get(int idx) {
        int ret = 0;
        while (idx > 0) {
            ret += data[idx];
            idx -= lowbit(idx);
        }
        return ret;
    }

    /**
     * 将索引为idx的值加val, 那么除了叶子节点, 它的父节点也要加val
     * @param idx
     * @param val
     */
    public void update(int idx, int val) {
        while (idx <= n) {
            data[idx] += val;
            idx += lowbit(idx);
        }
    }

    public static void main(String[] args) {

    }

}
