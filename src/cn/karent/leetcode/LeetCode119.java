package cn.karent.leetcode;

import java.util.*;

/**
 * 杨辉三角 二
 */
public class LeetCode119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> rets = new ArrayList<>();
        rets.add(1);
//        for(int i = 1; i <= rowIndex; i++) {
//            List<Integer> tmp = new ArrayList<>();
//            for(int j = 0; j < rets.size(); j++) {
//                if( j == 0) {
//                    tmp.add(1);
//                } else {
//                    tmp.add(rets.get(j) + rets.get(j-1));
//                }
//            }
//            tmp.add(1);
//            rets = tmp;
//        }
        // 优化空间
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = rets.size()-1; j > 0; j--) {
                rets.set(j, rets.get(j) + rets.get(j-1));
            }
            rets.add(1);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode119 lc = new LeetCode119();
        List<Integer> rets = lc.getRow(3);
        for(int i : rets) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
