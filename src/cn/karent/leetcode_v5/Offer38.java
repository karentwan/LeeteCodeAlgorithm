package cn.karent.leetcode_v5;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/***********************************************
 * description: 字符串的排列
 * @author wan
 * @date 2021.06.22
 ***********************************************/
public class Offer38 {
/*
    private void dfs(String s, int cnt, StringBuilder sb, boolean[] vis, Set<String> rets) {
        if( cnt == s.length()) {
            rets.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if( !vis[i]) {
                sb.append(s.charAt(i));
                vis[i] = true;
                dfs(s, cnt+1, sb, vis, rets);
                vis[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    // 如果元素有重复的该怎么办
    public String[] permutation(String s) {
        Set<String> list = new HashSet<>();
        dfs(s, 0, new StringBuilder(), new boolean[s.length()], list);
        String[] rets = new String[list.size()];
        Iterator<String> iter = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            rets[i] = iter.next();
        }
        return rets;
    }
  */

    private void dfs(char[] s, char[] chs, int idx, boolean[] vis, List<String> rets) {
        if( idx == chs.length) {
            rets.add(new String(chs));
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if( vis[i] || (i > 0 && !vis[i-1] && s[i] == s[i-1])) {
                continue;
            }
            chs[idx] = s[i];
            vis[i] = true;
            dfs(s, chs, idx+1, vis, rets);
            vis[i] = false;
        }
    }

    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        char[] tmps = s.toCharArray();
        Arrays.sort(tmps);
        dfs(tmps, new char[s.length()], 0, new boolean[s.length()], list);
        String[] rets = new String[list.size()];
        Iterator<String> iter = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            rets[i] = iter.next();
        }
        return rets;
    }

    public static void main(String[] args) {
        Offer38 lc = new Offer38();
//        String s = "abc";
        String s = "aab";
        String[] rets = lc.permutation(s);
        LeetCodeUtil.print(rets);
    }

}
