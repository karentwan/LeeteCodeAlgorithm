package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 等式方程的可满足性
 * @author wan
 * @date 2021.05.20
 ********************************************/
public class LeetCode990 {

    class DSU {
        private int[] parent;
        private int n;


        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return x == parent[x] ? x : (parent[x] = find(parent[x]));
        }

        // e 为true表示等于号
        public void union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if( px1 != px2) {
                parent[px1] = px2;
            }
        }

    }

    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if( equation.charAt(1) == '=') {
                dsu.union(a, b);
            }
        }
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if( equation.charAt(1) == '!' && dsu.find(a) == dsu.find(b)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode990 lc = new LeetCode990();
//        String[] eqs = {"a==b", "b!=a"};
//        String[] eqs = {"b==a","a==b"};
//        String[] eqs = {"a==b","b==c","a==c"};
//        String[] eqs = {"a==b","b!=c","c==a"};
//        String[] eqs = {"c==c","b==d","x!=z"};
//        String[] eqs = {"a!=a"};
//        String[] eqs = {"e==e","d!=e","c==d","d!=e"};
//        String[] eqs = {"e==e","d!=e","c==d","e!=d"};
//        String[] eqs = {"b!=c","a==b","e!=d","b!=f","a!=b"};
        String[] eqs = {"b!=f","c!=e","f==f","d==f","b==f","a==f"};
        boolean ret = lc.equationsPossible(eqs);
        System.out.println(ret);
    }

}
