package cn.karent.leetcode;

/**
 * 压缩字符串
 */
public class LeetCode443 {

    private int add(char[] chs, int idx, int n) {
        StringBuilder sb = new StringBuilder();
        while( n > 0) {
            int mod = n % 10;
            n /= 10;
            sb.insert(0, mod);
        }
        for(int i = 0; i < sb.length(); i++) {
            chs[idx++] = sb.charAt(i);
        }
        return idx;
    }

    public int compress(char[] chars) {
        int left = 0, mid = 0, right = 0;
        int n = chars.length;
        while( right < n) {
            mid = right;
            while( right + 1 < n && chars[right] == chars[right+1]) {
                right++;
            }
            int len = right - mid + 1;
            chars[left++] = chars[mid];
            if( len > 1) {
//                chars[left++] = (char)(len + '0');
                left = add(chars, left, len);
            }
            right++;
        }
        return left;
    }

    private static void print(char[] chs, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(chs[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeetCode443 lc = new LeetCode443();
        char[] chs = {'a','a','b','b','c','c','c'};
//        char[] chs = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        print(chs, chs.length);
        int len = lc.compress(chs);
        print(chs, len);
    }

}
