package cn.karent.leetcode;

/**
 * 优美的排列
 */
public class LeetCode526 {

    private int cnt = 0;

    private void dfs(int[] nums, boolean[] visited, int pos) {
        if( pos > nums.length) {
            cnt++;
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if( !visited[i] && (nums[i] % pos == 0 || pos % nums[i] == 0) ) {
                visited[i] = true;
                dfs(nums, visited, pos+1);
                visited[i] = false;
            }
        }
    }

    public int countArrangement(int n) {
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }
        boolean[] visited = new boolean[n];
        dfs(nums, visited, 1);
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode526 lc = new LeetCode526();
        int n = 2;
        int ret = lc.countArrangement(n);
        System.out.println(ret);
    }
}
