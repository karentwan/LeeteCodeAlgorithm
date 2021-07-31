package cn.karent.leetcode_v6;

import java.util.*;
import cn.karent.util.*;

/***********************************************
 * description: 二叉树的垂序遍历
 * @author wan
 * @date 2021.07.31
 ***********************************************/
public class LeetCode987 {

    private void dfs(TreeNode root, int row, int col, TreeMap<Integer, List<int[]>> map) {
        if( root == null) return;
        if( !map.containsKey(col))
            map.put(col, new ArrayList<>());
        List<int[]> list = map.get(col);
        list.add(new int[]{row, col, root.val});
        dfs(root.left, row+1, col-1, map);
        dfs(root.right, row+1, col+1, map);
    }

    // 时间复杂度 O(n) + O(nlog(n))
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> rets = new ArrayList<>();
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        Comparator<int[]> cmp = (k1, k2)->{
          if( k1[1] == k2[1])
              return k1[0] == k2[0] ? k1[2] - k2[2] : k1[0] - k2[0];
          return k1[1] - k2[1];
        };
        for (Integer key : map.keySet()) {
            List<int[]> tmp = map.get(key);
            Collections.sort(tmp, cmp);
            List<Integer> ret = new ArrayList<>();
            for (int[] t : tmp) {
                ret.add(t[2]);
            }
            rets.add(ret);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode987 lc = new LeetCode987();
//        Integer[] arr = {3,9,20,null,null,15,7};
        Integer[] arr = {1,2,3,4,5,6,7};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        List<List<Integer>> rets = lc.verticalTraversal(root);
        System.out.println(rets);
    }

}
