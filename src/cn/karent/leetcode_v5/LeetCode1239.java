package cn.karent.leetcode_v5;

import java.util.*;
import cn.karent.util.*;

/***********************************************
 * description: 串联字符串的最大长度
 * @author wan
 * @date 2021.06.19
 ***********************************************/
public class LeetCode1239 {

    private int ret = 0;

    private void dfs(List<Integer> arr, int idx, int mask) {
        if( idx >= arr.size()) {
            ret = Math.max(ret, Integer.bitCount(mask));
            return;
        }
        int t = arr.get(idx);
        if( (mask & t) == 0) {
            dfs(arr, idx+1, mask | t);
        }
        dfs(arr, idx+1, mask);
    }

    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            String s = arr.get(i);
            int m = 0;
            for (int j = 0; j < s.length(); j++) {
                int pos = 1 << (s.charAt(j) - 'a');
                if( (m & pos) != 0) {
                    m = 0;
                    break;
                }
                m |= pos;
            }
            if( m > 0)
                list.add(m);
        }
        dfs(list, 0, 0);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1239 lc = new LeetCode1239();
//        String[] arr = {"un", "iq", "ue"};
        String[] arr = {"cha","r","act","ers"};
        List<String> list = LeetCodeUtil.arr2list(arr);
        int ret = lc.maxLength(list);
        System.out.println(ret);
    }

}
