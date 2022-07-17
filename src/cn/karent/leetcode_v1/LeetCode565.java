package cn.karent.leetcode_v1;

/******************************************
 * 数组嵌套
 * @author wan
 * @date 2022.07.17 21:39
 ******************************************/
public class LeetCode565 {

    public int arrayNesting(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; j >= 0 && nums[j] != -1; ) {
                cnt++;
                int t = nums[j];
                nums[j] = -1;
                j = t;
            }
            ret = Math.max(ret, cnt);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode565 lc = new LeetCode565();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(lc.arrayNesting(nums));
    }

}
