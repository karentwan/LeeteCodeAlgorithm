package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 字母大小写全排列
 * @author wan
 * @date 2022.10.30 09:41
 ******************************************/
public class LeetCode784 {

    private void dfs(char[] chs, int idx, List<String> rets) {
        if (idx == chs.length) {
            String s = new String(chs);
            rets.add(s);
            return;
        }
        dfs(chs, idx+1, rets);
        char c = chs[idx];
        if (c >= 'a' && c <= 'z') {
            chs[idx] = (char) (c - 'a' + 'A');
            dfs(chs, idx+1, rets);
        } else if ( c >= 'A' && c <= 'Z') {
            chs[idx] = (char) (c - 'A' + 'a');
            dfs(chs, idx+1, rets);
        }
        chs[idx] = c;
    }

    public List<String> letterCasePermutation(String s) {
        char[] chs = s.toCharArray();
        List<String> rets = new ArrayList<>();
        dfs(chs, 0, rets);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode784 lc = new LeetCode784();
        String s = "a1b2";
        List<String> rets = lc.letterCasePermutation(s);
        LeetCodeUtil.print(rets);

    }

}
