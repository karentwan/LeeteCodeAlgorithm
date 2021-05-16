package cn.karent.leetcode_v4.weeklycontest241;

import java.util.*;

/********************************************
 * description: 构成交替字符串需要的最小交换次数
 * @author wan
 * @date 2021.05.16
 ********************************************/
public class Algo5760 {

    private int exchange(char[] chs, char cur) {
        int one = 0, zero = 0;  // 不合格的1和0的位置
        int ret = 0;
        int n = chs.length;
        // 当第一为1时
        for (int i = 0; i < n; i++) {
            if( chs[i] != cur) {  // 说明不合格, 要么交换, 要么记录
                if( cur == '1') {
                    if( one > 0) {
                        one--;
                        ret++;
                    } else zero++;
                } else {
                    if( zero > 0) {
                        zero--;
                        ret++;
                    } else one++;
                }
            }
            cur = cur == '1' ? '0' : '1';
        }
        return one == 0 && zero == 0 ? ret : -1;
    }

    public int minSwaps(String s) {
        char[] chs = s.toCharArray();
        int one = exchange(chs, '1');
        int zero = exchange(chs, '0');
        if( one == -1 ) return zero;
        else if( zero == -1) return one;
        else return Math.min(one, zero);
    }

    public static void main(String[] args) {
        Algo5760 lc = new Algo5760();
//        String s = "111000";
        String s = "010";
        int ret = lc.minSwaps(s);
        System.out.println(ret);
    }

}
