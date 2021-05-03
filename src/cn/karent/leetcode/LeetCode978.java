package cn.karent.leetcode;

/**
 * 最长湍流子数组
 */
public class LeetCode978 {

    public int maxTurbulenceSize(int[] arr) {
        if( arr.length == 0) {
            return 0;
        }
        int up = 1, down = 1;
        int ret = 1;
        for(int i = 1; i < arr.length; i++) {
            if( arr[i] == arr[i-1]) {
                up = 1;
                down = 1;
            } else if( arr[i] < arr[i-1]) {
                down = up + 1;
                up = 1;
            } else {
                up = down + 1;
                down = 1;
            }
            ret = Math.max(ret, Math.max(up, down));
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode978 lc = new LeetCode978();
//        int[] nums = {9,4,2,10,7,8,8,1,9};
        int[] nums = {4,8,12,16};
        int ret = lc.maxTurbulenceSize(nums);
        System.out.println(ret);
    }

}
