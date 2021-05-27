package cn.karent.other;

import java.util.*;
import cn.karent.util.*;

/**
 * 子数组
 */
public class SubArray {

    /**
     * 这种不好去重
     */
    public void dfs1(int[] nums, int idx, List<Integer> ret, List<List<Integer>> rets) {
        for(int i = idx; i < nums.length; i++) {
            ret.add(nums[i]);
            rets.add(new ArrayList<Integer>(ret));
            dfs1(nums, i+1, ret, rets);
            ret.remove(ret.size()-1);
            if( ret.size() > 0 && nums[idx] == ret.get(ret.size()-1)) {
                return;
            }
        }
    }

    public void dfs2(int[] nums, int idx, int parent, List<Integer> ret, List<List<Integer>> rets) {
        // 如果要让剪枝成功, 那么必须到末尾再加
        if( idx >= nums.length) {
            if( ret.size() > 0)
                rets.add(new ArrayList<>(ret));
            return;
        }
        ret.add(nums[idx]);
        dfs2(nums, idx+1, nums[idx], ret, rets);
        ret.remove(ret.size()-1);
        if( nums[idx] != parent) {   // 去重无敌小能手, 厉害
            dfs2(nums, idx+1, parent, ret, rets);
//            dfs2(nums, idx+1, nums[idx], ret, rets);  // 这个剪枝的手法是错误的
        }
    }

    private void dfs3(int[] nums, int idx, List<Integer> ret, List<List<Integer>> rets, Set<String> visited) {
        if( idx >= nums.length) {
            if( ret.size() > 0 && !visited.contains(ret.toString())) {
                rets.add(new ArrayList<>(ret));
                visited.add(ret.toString());
            }
            return;
        }
        ret.add(nums[idx]);
        dfs3(nums, idx+1, ret, rets, visited);
        ret.remove(ret.size()-1);
        dfs3(nums, idx+1, ret, rets, visited);
    }

    public static void main(String[] args) {
        SubArray sa = new SubArray();
//        int[] nums = {7,7,4,7};
        int[] nums = {1,2,2,3,4,5,2,3,4,5,2};
//        List<List<Integer>> rets = new ArrayList<>();
//        List<Integer> ret = new ArrayList<>();
//        sa.dfs1(nums, 0, ret, rets);
//        LeetCodeUtil.print(rets);
        System.out.println("=========================================================");
        List<Integer> ret = new ArrayList<>();
        List<List<Integer>> rets = new ArrayList<>();
        sa.dfs2(nums, 0, Integer.MAX_VALUE, ret, rets);
        LeetCodeUtil.print(rets);
        System.out.println(rets.size());
//        System.out.println("=========================================================");
//        List<Integer> ret = new ArrayList<>();
//        List<List<Integer>> rets = new ArrayList<>();
//        sa.dfs3(nums, 0, ret, rets, new HashSet<>());
//        LeetCodeUtil.print(rets);
//        System.out.println(rets.size());
    }

}
