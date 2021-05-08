package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 子集 二
 * @author wan
 * @date 2021.05.07
 ********************************************/
public class LeetCode90 {

//    private void dfs(int[] nums, int idx, int prev, List<Integer> ret, List<List<Integer>> rets) {
//        if( idx >= nums.length) {
//            if( ret.size() > 0) rets.add(new ArrayList<>(ret));
//            return;
//        }
//        ret.add(nums[idx]);
//        dfs(nums, idx+1, nums[idx], ret, rets);
//        ret.remove(ret.size()-1);
//        if( nums[idx] != prev) dfs(nums, idx+1, prev, ret, rets);
//    }
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> rets = new ArrayList<>();
//        rets.add(new ArrayList<>());
//        dfs(nums, 0, Integer.MIN_VALUE, new ArrayList<>(), rets);
//        return rets;
//    }


    private void dfs(int[] nums, int idx, List<Integer> ret, List<List<Integer>> rets) {
        for (int i = idx; i < nums.length; i++) {
            if( i > idx && nums[i] == nums[i-1]) continue;
            ret.add(nums[i]);
            rets.add(new ArrayList<>(ret));
            dfs(nums, i+1, ret, rets);
            ret.remove(ret.size()-1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rets = new ArrayList<>();
        rets.add(new ArrayList<>());
        dfs(nums, 0, new ArrayList<>(), rets);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode90 lc = new LeetCode90();
//        int[] nums = {1,2,2};
        int[] nums = {4,4,4,1,4};
//        int[] nums = {0};
        List<List<Integer>> rets = lc.subsetsWithDup(nums);
        System.out.println(rets);
    }

}
