package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 第一个错误的版本
 * @author wan
 * @date 2021.06.13
 ********************************************/
public class LeetCode278 extends VersionControl{

    public int firstBadVersion(int n) {
        int l = 1, r = n;
        while( l <= r) {
            int m = l + (r-l)/2;
            if( isBadVersion(m)) r = m-1;
            else l = m+1;
        }
        return l;
    }

    public static void main(String[] args) {

    }

}

class VersionControl {
    public boolean isBadVersion(int m) {
        return true;
    }
}
