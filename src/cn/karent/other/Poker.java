package cn.karent.other;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/***********************************************
 * description: 扑克牌算法
 * @author wan
 * @date 2021.06.21
 ***********************************************/
public class Poker {

    private int get(String s) {
        char[] chs = s.toCharArray();
        int ret = 0;
        switch( chs[0] ) {
            case 'S':
                ret = 100;
                break;
            case 'H':
                ret = 200;
                break;
            case 'B':
                ret = 300;
                break;
            case 'P':
                ret = 400;
                break;
        }
        ret += chs[1];
        return ret;
    }

    public void sort(String[] arr) {
        Arrays.sort(arr, (k1, k2) -> get(k1) - get(k2));
    }


    public void shuffle(String[] arr) {
        Random random = new Random();
        for (int i = arr.length-1; i >= 0; i--) {
            int j = random.nextInt(i+1);
            String t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        Poker lc = new Poker();
        String[] strs = {"B3", "B2", "B1", "P2", "H1", "H3", "H2", "S2", "S1"};
        LeetCodeUtil.print(strs);
        lc.sort(strs);
        LeetCodeUtil.print(strs);
        lc.shuffle(strs);
        LeetCodeUtil.print(strs);
    }

}
