package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 钥匙和房间
 */
public class LeetCode841 {

    private int cnt = 0;

    // rooms 房间列表, room 当前所在房间
    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        List<Integer> keys = rooms.get(room);
        for (Integer key : keys) {
            if( !visited[key] ) {
                cnt++;
                visited[key] = true;
                dfs(rooms, key, visited);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        cnt = 1;
        visited[0] = true;
        dfs(rooms, 0, visited);
        return cnt == n;
    }

    public static void main(String[] args) {
        LeetCode841 lc = new LeetCode841();
//        Integer[][] arr = {{1},{2},{3},{}};
        Integer[][] arr = {{1,3},{3,0,1},{2},{0}};
        List<List<Integer>> rooms = LeetCodeUtil.arr2list(arr);
        boolean ret = lc.canVisitAllRooms(rooms);
        System.out.println(ret);
    }
}
