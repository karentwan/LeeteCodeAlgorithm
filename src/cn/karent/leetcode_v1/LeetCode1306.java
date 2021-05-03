package cn.karent.leetcode_v1;

/**
 * 跳跃游戏 三
 */
public class LeetCode1306 {

    public boolean canReach(int[] arr, int start) {
        if( arr[start] == 0) {
            return true;
        }
        if( arr[start] == Integer.MIN_VALUE) {
            return false;
        }
        int t = arr[start];
        arr[start] = Integer.MIN_VALUE;
        int forward = start + t;
        if( forward >= 0 && forward < arr.length && canReach(arr, forward)) {
            return true;
        }
        int backward = start - t;
        if( backward >= 0 && backward < arr.length && canReach(arr, backward)) {
            return true;
        }
        arr[start] = t;
        return false;
    }

    public static void main(String[] args) {
        LeetCode1306 lc = new LeetCode1306();
//        int[] arr = {4,2,3,0,3,1,2};
//        int start = 5;
        int[] arr = {3,0,2,1,2};
        int start = 2;
        boolean ret = lc.canReach(arr, start);
        System.out.println(ret);
    }

}
