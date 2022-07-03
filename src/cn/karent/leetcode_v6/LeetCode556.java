package cn.karent.leetcode_v6;

/******************************************
 * 下一个更大的元素 三
 * 思考: 这道题涉及到哪些知识点?
 * @author wan
 * @date 2022.07.03 09:26
 ******************************************/
public class LeetCode556 {

    public int nextGreaterElement(int n) {
        char[] chs = (n + "").toCharArray();
        int i = chs.length-2;
        while (i >= 0 && chs[i] >= chs[i+1]) i--;
        if (i < 0) return -1;  // 全部是逆序
        // 找出比当前位置更大的一个位置
        int j = chs.length-1;
        while ( j > i && chs[j] <= chs[i]) j--;
        // 交换i和j的位置, 并将i后面的位置逆序
        char c = chs[i];
        chs[i] = chs[j];
        chs[j] = c;
        for (int i1 = i+1, i2 = chs.length-1; i1 < i2; i1++, i2--) {
            c = chs[i1];
            chs[i1] = chs[i2];
            chs[i2] = c;
        }
        String s = new String(chs);
        long tmp = Long.parseLong(s);
        if (tmp > Integer.MAX_VALUE) return -1;
        return (int) tmp;
    }

    public static void main(String[] args) {
        LeetCode556 lc = new LeetCode556();
        int n = 21;
        System.out.println(lc.nextGreaterElement(n));
    }

}
