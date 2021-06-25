package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 打开转盘锁
 * @author wan
 * @date 2021.06.25
 ***********************************************/
public class LeetCode752 {

    private void next(String s, Queue<String> que, Set<String> vis) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char t = chs[i];
            chs[i] = (char) ((t - '0' + 1) % 10 + '0');
            String s1 = new String(chs);
            if( !vis.contains(s1) ) {
                que.offer(s1);
                vis.add(s1);
            }
            chs[i] = ((char) ((t - '0' - 1 + 10) % 10 + '0'));
            s1 = new String(chs);
            if( !vis.contains(s1)) {
                que.offer(s1);
                vis.add(s1);
            }
            chs[i] = t;
        }
    }

    public int openLock(String[] deadends, String target) {
        if( target.equals("0000")) return 0;
        Set<String> vis = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.offer("0000");
        vis.add("0000");
        Set<String> deads = new HashSet<>();
        if( deads.contains("0000")) return -1;
        int ret = 0;
        for (int i = 0; i < deadends.length; i++) {
            deads.add(deadends[i]);
        }
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String s = que.poll();
                if( s.equals(target)) return ret;
                if( deads.contains(s)) continue;
                next(s, que, vis);
            }
            ret++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode752 lc = new LeetCode752();
        String[] deads = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int ret = lc.openLock(deads, target);
        System.out.println(ret);
    }

}
