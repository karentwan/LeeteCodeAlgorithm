package cn.karent.leetcode;

/**
 * 爱生气的书店老板
 */
public class LeetCode1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int i = 0, j = 0;
        int left = 0;
        int max = 0;
        int wnd = 0;
        while( j < customers.length ) {
            wnd += customers[j] * grumpy[j];
            j++;
            if( wnd > max) {
                max = wnd;
                left = i;
            }
            if( j - i == X) {
                wnd -= customers[i] * grumpy[i];
                i++;
            }
        }
        int ret = 0;
        for(i = 0; i < customers.length; i++) {
            if( i < left || i >= left + X) {
                ret += customers[i] * (1 - grumpy[i]);
            } else {
                ret += customers[i];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1052 lc = new LeetCode1052();
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int x = 3;
        int ret = lc.maxSatisfied(customers, grumpy, x);
        System.out.println(ret);
    }

}
