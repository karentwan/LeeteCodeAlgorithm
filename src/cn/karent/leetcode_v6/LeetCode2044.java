package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-03-15 07:50
 * @description: 统计按位或能得到最大值的子集数目
 *******************************************/
public class LeetCode2044 {

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0, cnt = 0;
        // 所有子集的选法位2 ^ n - 1个
        for (int i = 0; i < 1 << nums.length; i++) {
            int orVal = 0;
            // 外层遍历表示i为一个选集
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {  // true表示i这个选集选中了第j个元素
                    orVal |= nums[j];
                }
            }
            if (orVal > maxOr) {
                maxOr = orVal;
                cnt = 1;
            } else if (orVal == maxOr) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode2044 lc = new LeetCode2044();
        int[] nums = {3,1};
        System.out.println(lc.countMaxOrSubsets(nums));
    }

}
