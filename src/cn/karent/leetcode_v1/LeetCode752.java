package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 打开转盘锁
 */
public class LeetCode752 {

    // 单向BFS
    public int openLock1(String[] deadends, String target) {
        Queue<String> que = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }
        que.add("0000");
        visited.add("0000");
        int ret = 0;
        boolean flag = false;
        while ( !que.isEmpty() && !flag ) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String s = que.poll();
                if( target.equals(s) ) {
                    flag = true;
                    break;
                }
                if( set.contains(s) ) {
                    continue;
                }
                add(que, s, visited);
            }
            if( !flag ) {
                ret++;
            }
        }
        return flag ? ret : -1;
    }

    private void add(Queue<String> que, String s, Set<String> visited) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char ch = chs[i];
            chs[i] = ((char) (((chs[i] - '0' + 1) % 10) + '0'));
            String tmp = new String(chs);
            if( !visited.contains(tmp) ) {
                que.add(tmp);
                visited.add(tmp);
            }
            chs[i] = ((char) (((chs[i] - '0' - 2 + 10) % 10) + '0'));
            tmp = new String(chs);
            if( !visited.contains(tmp) ) {
                que.add(tmp);
                visited.add(tmp);
            }
            chs[i] = ch;
        }
    }

    // 双向BFS
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            set.add(deadend);
        }
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add("0000");
        q2.add(target);
        int ret = 0;
        boolean flag = false;
        while( !q1.isEmpty() && !q2.isEmpty() && !flag) {
            HashSet<String> tmp = new HashSet<>();
            if( q1.size() > q2.size()) {
                Set<String> t = q1;
                q1 = q2;
                q2 = t;
            }
            for ( String s : q1) {
                if( q2.contains(s) ) {
                    flag = true;
                    break;
                }
                if( set.contains(s)) {
                    continue;
                }
                visited.add(s);
                add(tmp, q1, s, visited);
            }
            if( !flag ) {
                ret++;
            }
            q1 = tmp;
        }
        return flag ? ret : -1;
    }

    private void add(Set<String> set, Set<String> cur, String s, Set<String> visited) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < 4; i++) {
            char ch = chs[i];
            chs[i] = ((char) (((chs[i] - '0' + 1) % 10) + '0'));
            String tmp = new String(chs);
            if( !visited.contains(tmp) && !cur.contains(tmp)) {
                set.add(tmp);
            }
            chs[i] = ((char) (((chs[i] - '0' - 2 + 10) % 10) + '0'));
            tmp = new String(chs);
            if( !visited.contains(tmp) && !cur.contains(tmp) ) {
                set.add(tmp);
            }
            chs[i] = ch;
        }
    }

    public static void main(String[] args) {
        LeetCode752 lc = new LeetCode752();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
//        String[] deadends = {"8888"};
//        String target = "0009";
//        String[] deadends = {"8887","8889","8878","8898","8788","8988","7888","9888"};
//        String target = "8888";
        int ret = lc.openLock(deadends, target);
        System.out.println(ret);
    }

}
