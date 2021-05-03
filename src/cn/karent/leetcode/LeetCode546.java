package cn.karent.leetcode;

/**
 * 移除盒子
 */
public class LeetCode546 {

    private int ret = 1;

    private int dfs(StringBuilder sb) {
        int i = 0, j = 0;
        int val = 0;
        while( i < sb.length() ) {
            StringBuilder tmp = new StringBuilder(sb);
            j = i+1;
            while( j < sb.length() && sb.charAt(j) == sb.charAt(j-1)) {
                j++;
            }
            tmp.delete(i, j);
            val = Math.max(val, (j-i) * (j-i) + dfs(tmp));
            i = j;
        }
        ret = Math.max(val, ret);
        return val;
    }

    // 超时
    public int removeBoxes1(int[] boxes) {
        StringBuilder sb = new StringBuilder();
        for(int i : boxes) {
            sb.append(i);
        }
        dfs(sb);
        return ret;
    }

    private int[][][] dp = new int[100][100][100];

    /**
     * dp(l, r, k) 区间[l, r] + k个等于a_r的元素
     * @param boxes
     * @param l
     * @param r
     * @param k
     * @return
     */
    private int dfsWithMemo(int[] boxes, int l, int r, int k) {
        if( l > r) {
            return 0;
        }
        if( dp[l][r][k] != 0) {
            return dp[l][r][k];
        }
        dp[l][r][k] = (k+1)*(k+1) + dfsWithMemo(boxes, l, r-1, 0);
        for(int i = l; i < r; i++) {
            if( boxes[i] == boxes[r]) {
                dp[l][r][k] = Math.max(dp[l][r][k], dfsWithMemo(boxes, l, i, k+1) + dfsWithMemo(boxes, i+1, r-1, 0));
            }
        }
        return dp[l][r][k];
    }

    public int removeBoxes(int[] boxes) {
        int ret = dfsWithMemo(boxes, 0, boxes.length-1, 0);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode546 lc = new LeetCode546();
        int[] nums = {1,3,2,2,2,3,4,3,1};
//        int[] nums = {1,1,1};
        int ret = lc.removeBoxes(nums);
        System.out.println(ret);
    }
}
