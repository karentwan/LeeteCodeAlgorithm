package cn.karent.leetcode_v6;

import java.util.*;

/******************************************
 * 黑名单中的随机数
 * @author wan
 * @date 2022.06.26 09:40
 ******************************************/
public class LeetCode710 {

    Map<Integer, Integer> b2w;
    Random random;
    int bound;

    public LeetCode710(int n, int[] blacklist) {
        b2w = new HashMap<>();
        random = new Random();
        int m = blacklist.length;
        bound = n - m;
        // 将[0, n-m)中的黑名单元素映射到[n-m, n)空间里面
        Set<Integer> set = new HashSet<>();
        for (int i : blacklist) {
            if (i >= bound) {
                set.add(i);
            }
        }
        int w = n-m;
        for (int i : blacklist) {
            if (i < bound) {
                while (set.contains(w)) w++;
                b2w.put(i, w++);
            }
        }
    }

    public int pick() {
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }

    public static void main(String[] args) {
        int n = 0;
        int[] blacklist = null;
        LeetCode710 lc = new LeetCode710(n, blacklist);

    }

}
