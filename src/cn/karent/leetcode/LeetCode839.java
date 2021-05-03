package cn.karent.leetcode;

/**
 * 相似的字符串组
 */
public class LeetCode839 {

    /**
     * 判断两个字符串是否是相似的, 不一定要使用模拟的算法, 一般来说, 直接使用模拟的
     * 算法效率都不高, 应该使用数学统计的算法
     * @param word1
     * @param word2
     * @return
     */
    private boolean similar(String word1, String word2) {
        int diff = 0;
        int i = 0;
        while( i < word1.length() && i < word2.length()) {
            if( word1.charAt(i) != word2.charAt(i)) {
                diff++;
            }
            i++;
        }
        return word1.length() == word2.length() && diff <= 2;
    }

    class DSU {

        private int n;

        private int[] parent = null;

        private int cnt = 0;

        public DSU(int n) {
            this.n = n;
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
            cnt = n;
        }

        public int find(int idx) {
            if( parent[idx] == idx) {
                return idx;
            }
            parent[idx] = find(parent[idx]);
            return parent[idx];
        }

        public void union(int x1, int x2) {
            int px1 = find(x1);
            int px2 = find(x2);
            if( px1 != px2) {
                parent[px2] = px1;
                cnt--;
            }
        }

        public int get() {
            return cnt;
        }

    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU dsu = new DSU(n);
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if( similar(strs[i], strs[j])) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.get();
    }

    public static void main(String[] args) {
        LeetCode839 lc = new LeetCode839();
        String[] words = {"tars","rats","arts","star"};
        int ret = lc.numSimilarGroups(words);
        System.out.println(ret);
    }

}
