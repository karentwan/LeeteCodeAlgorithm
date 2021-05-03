package cn.karent.leetcode_v2.weeklycontest234;

/**
 * 还原排列的最少操作步数
 */
public class Algo5715 {

    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            arr[i] = i;
        }
        int cnt = 0;
        boolean flag = false;
        while (!flag) {
            int[] tmp = new int[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                if( i % 2 == 0) {
                    arr[i] = tmp[i / 2];
                } else {
                    arr[i] = tmp[n / 2 + (i-1)/2];
                }
            }
            flag = true;
            for (int i = 0; i < n; i++) {
                if( arr[i] != perm[i]) {
                    flag = false;
                    break;
                }
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Algo5715 algo = new Algo5715();
        int n = 6;
        int ret = algo.reinitializePermutation(n);
        System.out.println(ret);
    }

}
