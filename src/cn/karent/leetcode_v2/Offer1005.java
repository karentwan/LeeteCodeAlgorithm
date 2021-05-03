package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 稀疏数组查找
 * @author wan
 * @date 2021.04.07
 */
public class Offer1005 {

    /**
     * 类似于“含有重复元素的旋转数组”系列的题目，当遇到了特殊值导致正常的二分无法继续时，就临时退化为线性遍历
     * @param words
     * @param s
     * @return
     */
    public int findString(String[] words, String s) {
        int l = 0, r = words.length-1;
        while ( l <= r) {
            int mid = l + (r - l) / 2;
            int t = mid;
            while (mid <= r && words[mid].length() == 0) {
                mid++;
            }
            if( mid > r) {
                r = t-1;
                continue;
            }
            int c = words[mid].compareTo(s);
            if( c == 0) {
                return mid;
            } else if( c > 0) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
