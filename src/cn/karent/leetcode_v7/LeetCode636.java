package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 函数的独占时间
 * @author wan
 * @date 2022.08.07 09:48
 ******************************************/
public class LeetCode636 {

    private int calc(List<String> logs, int idx1, int idx2, int[] rets, int t) {
        String s1 = logs.get(idx1);
        String s2 = logs.get(idx2);
        String[] strs1 = s1.split(":");
        String[] strs2 = s2.split(":");
        int id = Integer.parseInt(strs1[0]), id2 = Integer.parseInt(strs2[0]);
        String op1 = strs1[1], op2 = strs2[1];
        int t1 = Integer.parseInt(strs1[2]), t2 = Integer.parseInt(strs2[2]);
        rets[id] += t2 - t1 + 1 + t;
        return t2 - t1 + 1;
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] rets = new int[n];
        LinkedList<int[]> st = new LinkedList<>();
        for (int i = 0; i < logs.size(); i++) {
            String[] s = logs.get(i).split(":");
            if ("start".equals(s[1])) {
                st.offerLast(new int[]{i, 0});
            } else {
                int[] tmps = st.pollLast();
                int t = calc(logs, tmps[0], i, rets, tmps[1]);
                if (!st.isEmpty()) {
                    st.peekLast()[1] -= t;
                }
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode636 lc = new LeetCode636();
//        int n = 2;
//        String[] arr = {"0:start:0", "1:start:2", "1:end:5", "0:end:6"};
        int n = 8;
        String[] arr = {"0:start:0","1:start:5","2:start:6","3:start:9","4:start:11","5:start:12","6:start:14","7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40","3:end:45","0:start:49","0:end:54","5:start:55","5:end:59","4:start:63","4:end:66","2:start:69","2:end:70","2:start:74","6:start:78","0:start:79","0:end:80","6:end:85","1:start:89","1:end:93","2:end:96","2:end:100","1:end:102","2:start:105","2:end:109","0:end:114"};
        List<String> list = LeetCodeUtil.arr2list(arr);
        int[] rets = lc.exclusiveTime(n, list);
        LeetCodeUtil.print(rets);
    }

}
