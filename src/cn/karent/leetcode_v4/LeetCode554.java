package cn.karent.leetcode_v4;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/********************************************
 * description: 砖墙
 * @author wan
 * @date 2021.05.02
 ********************************************/
public class LeetCode554 {

    public int leastBricks(List<List<Integer>> wall) {
        if( wall.size() == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < wall.size(); i++) {
            int sum = 0;
            for (Integer item : wall.get(i)) {
                sum += item;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            map.remove(sum);
        }
        int n = wall.size();
        int ret = n;
        for(int key : map.keySet()) {
            int val = map.get(key);
            System.out.println(val);
            ret = Math.min(ret, n - val);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode554 lc = new LeetCode554();
//        Integer[][] arr = {{1,2,2,1},{3,1,2},{1,3,2},{2,4},{3,1,2},{1,3,1,1}};
        Integer[][] arr = {{1},{1},{1}};
        List<List<Integer>> wall = LeetCodeUtil.arr2list(arr);
        int ret = lc.leastBricks(wall);
        System.out.println(ret);
    }

}
