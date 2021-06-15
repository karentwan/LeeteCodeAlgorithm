package cn.karent.other;

import java.util.*;

/********************************************
 * description: 匈牙利算法 -- 最大二分图匹配算法
 * @author wan
 * @date 2021.06.15
 ********************************************/
public class HungarianAlgo {

    private int n;

    private int[] p;       // 右边元素的左边映射

    private int[][] edges;  // 邻接矩阵

    public HungarianAlgo(int n) {
        this.n = n;
        p = new int[n+1];
        edges = new int[n+1][n+1];
    }

    /**
     * 将一个图分成一个二部图,
     * @param x 左边
     * @param visited 右边图是否已经被访问过
     * @return 增广路径是否成功
     */
    private boolean match(int x, boolean[] visited) {
        int[] edge = edges[x];
        for (int i = 1; i <= n; i++) {
            if( edge[i] != 0 && !visited[i]) {
                visited[i] = true;
                if( p[i] == 0 || match(p[i], visited)) {
                    p[i] = x;
                    return true;
                }
            }
        }
        return false;
    }

    public int hungarian() {
       int cnt = 0;
       for (int i = 1; i <= n; i++) {
           if( match(i, new boolean[n+1])) cnt++;
       }
       return cnt;
    }

    public static void main(String[] args) {

    }

}
