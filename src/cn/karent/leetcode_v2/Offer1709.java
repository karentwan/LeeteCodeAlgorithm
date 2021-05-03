package cn.karent.leetcode_v2;

/**
 * 第k个数
 */
public class Offer1709 {

    public int getKthMagicNumber(int k) {
        int[] rets = new int[k];
        int idx = 1;
        rets[0] = 1;
        int p1 = 0, p2 = 0, p3 = 0;
        while ( idx < k ) {
            rets[idx] = Math.min(rets[p1] * 3, Math.min(rets[p2] * 5, rets[p3] * 7));
            if( rets[idx] == rets[p1] * 3) {
                p1++;
            }
            if( rets[idx] == rets[p2] * 5) {
                p2++;
            }
            if( rets[idx] == rets[p3] * 7){
                p3++;
            }
            idx++;
        }
        return rets[k-1];
    }

    public static void main(String[] args) {
        Offer1709 offer = new Offer1709();
        int k = 7;
        int ret = offer.getKthMagicNumber(k);
        System.out.println(ret);
    }

}
