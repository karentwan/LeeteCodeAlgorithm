package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 用栈操作构建数组
 * @author wan
 * @date 2022.10.15 09:52
 ******************************************/
public class LeetCode1441 {

    public List<String> buildArray(int[] target, int n) {
        final String PUSH = "Push";
        final String POP = "Pop";
        List<String> rets = new ArrayList<>();
        for (int i = 1, idx = 0; i <= n && idx < target.length; i++) {
            if (i == target[idx]) {
                rets.add(PUSH);
                idx++;
            } else {
                rets.add(PUSH);
                rets.add(POP);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1441 lc = new LeetCode1441();
    }

}
