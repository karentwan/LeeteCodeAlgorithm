package cn.karent.leetcode;

/**
 * 情侣牵手
 */
public class LeetCode765 {

    /**
     * 贪心, 固定偶数情侣的位置, 查找它的情侣在不在身边
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        int cnt = 0;
        for(int i = 0; i < row.length; i += 2) {
            int obj = findCouple(row[i]);
            if( row[i+1] != obj) {
                int idx = find(obj, row);
                int tmp = row[idx];
                row[idx] = row[i+1];
                row[i+1] = tmp;
                cnt++;
            }
        }
        return cnt;
    }

    private int find(int obj, int[] row) {
        for(int i = 0; i < row.length; i++) {
            if( row[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    private int findCouple(int n) {
        if( (n & 1) == 0) {  // 偶数
            return n+1;
        } else {
            return n-1;
        }
    }

}
