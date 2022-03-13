package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-03-13 09:17
 * @description: UTF-8编码验证
 *******************************************/
public class LeetCode393 {

    private int getLength(int d) {
        int i = 7, n = 0;
        while (i >= 0 && ((d >> i) & 1) == 1) {
            i--;
            n++;
        }
        return n;
    }

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ) {
            // 读取第一位
            int d = getLength(data[i]);
            if (d == 1 || d > 4) return false;
            i++; d -= 2;
            while (d >= 0 && i < data.length) {
                int next = getLength(data[i]);
                if (next != 1) return false;
                d--; i++;
            }
            if (d >= 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode393 lc = new LeetCode393();
//        int[] data = {197,130,1};
//        int[] data = {235,140,4};
        int[] data = {250,145,145,145,145};
        System.out.println(lc.validUtf8(data));
    }

}
