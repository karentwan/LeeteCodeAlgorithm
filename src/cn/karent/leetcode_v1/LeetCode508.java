package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 出现次数最多的子树元素和
 */
public class LeetCode508 {

    private List<Integer> ans = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();
    private int cnt = 0;
    private int maxCnt = 0;
    private int base = Integer.MAX_VALUE;

    private int dfs(TreeNode root) {
        if( root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int val = left + right + root.val;
//        update(val);
        tmp.add(val);
        return val;
    }

    private void update(int val) {
        if( val == base) {
            cnt++;
        } else {
            cnt = 1;
            base = val;
        }
        if( cnt == maxCnt) {
            ans.add(val);
        } else if( cnt > maxCnt) {
            ans.clear();
            maxCnt = cnt;
            ans.add(val);
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        Collections.sort(tmp);
        for (int val : tmp) {
            update(val);
        }
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode508 lc = new LeetCode508();
        Integer[] arr = {5, 2, -3};
//        Integer[] arr = {5,2,-5};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int[] rets = lc.findFrequentTreeSum(root);
        for (int ret : rets) {
            System.out.println(ret);
        }
    }

}
