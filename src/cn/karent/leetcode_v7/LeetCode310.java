package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 最小高度树
 * @author wan
 * @date 2022.09.17 10:40
 ******************************************/
public class LeetCode310 {

    // 拓扑排序, 删除度为1的节点, 最后剩下的一定是根节点
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        int[] indg = new int[n];
        List[] listEdges = new List[n];
        for (int i = 0; i < n; i++) {
            listEdges[i] = new ArrayList();
        }
        for (int[] edge : edges) {
            int s = edge[0], e = edge[1];
            indg[s]++; indg[e]++;
            listEdges[s].add(e);
            listEdges[e].add(s);
        }
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indg[i] == 1) {
                st.offerLast(i);
            }
        }
        int remain = n - st.size();
        while (!st.isEmpty() && remain > 0) {
            int size = st.size();
            for (int j = 0; j < size; j++) {
                Integer s = st.pollFirst();
                List<Integer> edge = listEdges[s];
                for (int i = 0; i < edge.size(); i++) {
                    Integer idx = edge.get(i);
                    indg[idx]--;
                    if (indg[idx] == 1) {
                        st.offerLast(idx);
                        remain--;
                    }
                }
            }
        }
        List<Integer> rets = new ArrayList<>();
        while (!st.isEmpty()) {
            rets.add(st.pollLast());
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode310 lc = new LeetCode310();
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> rets = lc.findMinHeightTrees(n, edges);
        LeetCodeUtil.print(rets);
    }

}
