package cn.karent.leetcode;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/**
 * 破解保险箱
 * 将该问题抽象成为一个图, 每个图有n个节点
 * Hierholzer 算法
 */
public class LeetCode753 {

    private Set<Integer> visited = new HashSet<>();

    private int node = 0;

    private void dfs(int cur, int k, StringBuilder sb) {
        cur = cur % node;
        for(int i = 0; i < k; i++) {
            int t = cur * 10 + i;
            if( !visited.contains(t)) {  // 说明是新节点, visited
                visited.add(t);
                dfs(t, k, sb);
                sb.append(i);
            }
        }
    }

    /**
     * 一共 k^n个不同的密码串
     * 构建成k^(n-1)方个节点
     * @param n
     * @param k
     * @return
     */
    public String crackSafe(int n, int k) {
        StringBuilder ret = new StringBuilder();
        node = (int)Math.pow(10, n-1);
        dfs(0, k, ret);
        for(int i = 0; i < n-1; i++) {
            ret.append('0');
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        LeetCode753 lc = new LeetCode753();
        int n = 3;
        int k = 2;
        String ret = lc.crackSafe(n, k);
        System.out.println(ret);
    }
}
