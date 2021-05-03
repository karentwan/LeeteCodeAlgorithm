package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 函数独占时间
 */
public class LeetCode636 {

    class Fun {
        private int id;
        private String sn;
        private int time;
        public Fun() {}

        public Fun(int id, String sn, int time) {
            this.id = id;
            this.sn = sn;
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public boolean equalsSN(String s) {
            return sn.equals(s);
        }

    }

    private Fun parseString(String s) {
        String[] str = s.split(":");
        int id = Integer.valueOf(str[0]);
        String sn = str[1];
        int time = Integer.valueOf(str[2]);
        return new Fun(id, sn, time);
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Fun> st = new Stack<>();
        int[] rets = new int[n];
        Fun pre = null;
        for(String s : logs) {
            Fun f = parseString(s);
            if( st.isEmpty()) {
                st.push(f);
                pre = f;
            } else {
                if( pre.equalsSN("start") && f.equalsSN("start")) {
                    st.push(f);
                    rets[pre.getId()] += f.getTime() - pre.getTime();
                } else if( pre.equalsSN("start") && f.equalsSN("end")) {
                    st.pop();
                    rets[pre.getId()] += f.getTime() - pre.getTime() + 1;
                } else if( pre.equalsSN("end") && f.equalsSN("start")) {
                    rets[st.peek().getId()] += f.getTime() - pre.getTime() - 1;
                    st.push(f);
                } else {
                    st.pop();
                    rets[f.getId()] += f.getTime() - pre.getTime();
                }
                pre = f;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode636 lc = new LeetCode636();
//        int n = 2;
//        String[] arr = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        int n = 1;
        String[] arr = {"0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"};
//        int n = 2;
//        String[] arr = {"0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"};
        List<String> logs = LeetCodeUtil.arr2list(arr);
        int[] rets = lc.exclusiveTime(n, logs);
        for(int i : rets) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
