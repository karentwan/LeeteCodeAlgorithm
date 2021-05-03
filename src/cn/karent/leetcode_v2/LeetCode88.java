package cn.karent.leetcode_v2;


/**
 * 合并两个有序数组
 * @author wan
 * @date 2021.04.05
 */
public class LeetCode88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] tmps = Arrays.copyOf(nums1, m);
//        int i = 0, j = 0, k = 0;
//        while (i < m && j < n) {
//            if( tmps[i] <= nums2[j]) {
//                nums1[k] = tmps[i++];
//            } else {
//                nums1[k] = nums2[j++];
//            }
//            k++;
//        }
//        while (i < m) {
//            nums1[k++] = tmps[i++];
//        }
//        while (j < n) {
//            nums1[k++] = nums2[j++];
//        }
        int i = m-1, j = n-1, k = nums1.length-1;
        while ( i >= 0 && j >= 0) {
            if( nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
            k--;
        }
        while ( i >= 0) {
            nums1[k--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        LeetCode88 lc = new LeetCode88();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        lc.merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }

}
