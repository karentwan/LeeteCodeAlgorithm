package cn.karent.leetcode_v6;

import java.util.*;

/**
 * 格雷编码
 * 使用回溯来做
 */
public class LeetCode89 {

    private List<Integer> rets = null;

    private boolean dfs(int n, int c, int size, List<Integer> list, Set<Integer> vis) {
        if (vis.contains(c)) {
            boolean flag = vis.size() == size && c == 0;
            if (flag) {
                rets = new ArrayList<>(list);
            }
            return flag;
        }
        vis.add(c);
        list.add(c);
        for (int i = 0; i < n; i++) {
            int tmp = c ^ (1 << i);
            if (dfs(n, tmp, size, list, vis)) {
                vis.remove(c);
                list.remove(list.size()-1);
                return true;
            }
        }
        vis.remove(c);
        list.remove(list.size()-1);
        return false;
    }

    public List<Integer> grayCode(int n) {
        int size = ((int) Math.pow(2, n));
        dfs(n, 0, size, new ArrayList<>(), new HashSet<>());
        return rets;
    }

    public static void main(String[] args) {
        LeetCode89 lc = new LeetCode89();
        int n = 1;
        System.out.println(lc.grayCode(n));
    }

}
