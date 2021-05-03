package cn.karent.leetcode_v2;

/**
 * 旋转数组
 */
public class LeetCode189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if( n == 0 || ( k = k % n) == 0) {
            return;
        }
        int cnt = 0;
        int start = -1;
        int tmp = 0;
        while ( cnt < n) {
            int i = ++start;
            int prev = nums[i];
            do {
                i = (i + k) % n;
                tmp = nums[i];
                nums[i] = prev;
                prev = tmp;
                cnt++;
            } while (i != start);
        }
    }

    public static void main(String[] args) {
        LeetCode189 lc = new LeetCode189();
//        int[] nums = {1,2,3,4,5,6,7};
//        int k = 3;
        int[] nums = {-1,-100,3,99};
        int k = 2;
        print(nums);
        lc.rotate(nums, k);
        print(nums);
    }

    private static void print(int[] nums) {
        System.out.print("[");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println("]");
    }

}
