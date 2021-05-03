package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 模拟行走机器人
 * @author wan
 * @date 2021.04.14
 */
public class LeetCode874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, dir = 0, ret = 0;
        Set<Long> set = new HashSet<>();
        int[] rows = {0, 1, 0, -1};
        int[] cols = {1, 0, -1, 0};
        // 对obstacle进行编码
        for (int[] obstacle : obstacles) {
            long tx = obstacle[0] + 3000;
            long ty = obstacle[1] + 3000;
            set.add((tx << 16) + ty);
        }
        for (int cmd : commands) {
            if( cmd == -1) {
                dir = (dir + 1) % 4;
            } else if( cmd == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < cmd; i++) {
                    int nx = x + rows[dir];
                    int ny = y + cols[dir];
                    long tmp = ((nx + 3000) << 16) + ny + 3000;
                    if(set.contains(tmp)) break;
                    x = nx;
                    y = ny;
                    ret = Math.max(ret, x * x + y * y);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode874 lc = new LeetCode874();
//        int[] commands = {4,-1,3};
//        int[][] obstacles = {};
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        int ret = lc.robotSim(commands, obstacles);
        System.out.println(ret);
    }

}
