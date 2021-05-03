package cn.karent.leetcode;

import java.util.*;

/**
 * 删除无效的括号
 */
public class LeetCode301 {

    public boolean validBracket(String s) {
        int cnt = 0;
        for(int i = 0; i < s.length() && cnt >= 0; i++) {
            if( s.charAt(i) == '(') {
                cnt++;
            } else if( s.charAt(i) == ')') {
                cnt--;
            }
        }
        return cnt == 0;
    }

    public List<String> removeInvalidParentheses(String s) {
        if( s.length() == 0 ) {
            List<String> ret = new ArrayList<>();
            ret.add("");
            return ret;
        }
        Queue<String> que = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        que.offer(s);
        while( !que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                String tmp = que.poll();
                if( validBracket(tmp)) {
                    set.add(tmp);
                }
                StringBuilder sb = new StringBuilder(tmp);
                // 开始删除括号
                for(int j = 0; j < tmp.length(); j++) {
                    if( j > 0 && tmp.charAt(j) == tmp.charAt(j-1)) {
                        continue;
                    }
                    if( sb.charAt(j) != '(' && sb.charAt(j) != ')') {
                        continue;
                    }
                    char ch = sb.charAt(j);
                    sb.deleteCharAt(j);
                    if( visited.contains(sb.toString())) {
                        sb.insert(j, ch);
                        continue;
                    }
                    visited.add(sb.toString());
                    que.offer(sb.toString());
                    sb.insert(j, ch);
                }
            }
            if(set.size() > 0) {
                break;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        LeetCode301 lc = new LeetCode301();
//        String s = "()())()";
//        String s = "(a)())()";
//        String s = ")(";
        String s = ")()(e()))))))((((";
        List<String> rets = lc.removeInvalidParentheses(s);
        for(String bracket : rets) {
            System.out.println(bracket);
        }
    }
}
