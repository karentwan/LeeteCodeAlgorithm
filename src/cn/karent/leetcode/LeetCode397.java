package cn.karent.leetcode;

/**
 * 整数替换
 */
public class LeetCode397 {

    public int integerReplacement(int n) {
        int cnt = 0;
        while( n > 1) {
            if( n == 3 ) {
                n--;
            } else if( (n & 1) == 0) {  // 偶数
                n >>>= 1;
            } else {  // 如果加1能够连续两次右移, 那么才会比减一的次数少
                n = (n + 1) % 4 == 0 ? n+1:n-1;
            }
            cnt++;
        }
        return cnt;
    }

}
