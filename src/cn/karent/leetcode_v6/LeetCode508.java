package cn.karent.leetcode_v6;

import cn.karent.util.LeetCodeUtil;
import cn.karent.util.TreeNode;
import java.util.*;

/******************************************
 * 出现次数最多的子树元素和
 * @author wan
 * @date 2022.06.19 09:40
 ******************************************/
public class LeetCode508 {

    private Map<Integer, Integer> map = new HashMap<>();

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int val = left + right + root.val;
        int cnt = 0;
        if (map.containsKey(val)) {
            cnt = map.get(val);
        }
        map.put(val, cnt+1);
        return val;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        // 统计数量
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            maxCnt = Math.max(maxCnt, v);
        }
        List<Integer> tmps = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCnt) {
                tmps.add(entry.getKey());
            }
        }
        int[] rets = new int[tmps.size()];
        for (int i = 0; i < rets.length; i++) {
            rets[i] = tmps.get(i);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode508 lc = new LeetCode508();
//        Integer[] arr = {5, 2, -3};
        Integer[] arr = {5, 2, -5};
        TreeNode tree = LeetCodeUtil.arr2tree(arr);
        int[] rets = lc.findFrequentTreeSum(tree);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }

    }

}
