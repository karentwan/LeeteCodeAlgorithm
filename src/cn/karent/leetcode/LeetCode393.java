package cn.karent.leetcode;

/**
 * UTF-8编码验证
 */
public class LeetCode393 {

    private int get(int d) {
        if((d & 0xF8) == 0xF8) {
            return -1;
        }
        if((d & 0xF0) == 0xF0) {
            return 3;
        }
        if((d & 0xE0) == 0xE0) {
            return 2;
        }
        if((d & 0xC0) == 0xC0) {
            return 1;
        }
        if((d & 0x80) == 0x80 ) {
            return -1;
        }
        return 0;
    }

    public boolean validUtf8(int[] data) {
        if( data.length == 0) {
            return false;
        }
        int n = 0;
        for(int i = 0; i < data.length; i++) {
            if( n == 0) {  // 开始验证UTF-8编码
                n = get(data[i]);
                if( n < 0) {
                    return false;
                }
            } else {
                if( (data[i] & 0xC0) == 0x80 && (data[i] & 0x40) == 0 ) {
                    n--;
                } else {
                    return false;
                }
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        LeetCode393 lc = new LeetCode393();
//        int[] nums = {145}; // false
//        int[] nums = {197, 130, 1};  // true
//        int[] nums = {228,189,160,229,165,189,13,10};  // true
        int[] nums = {39,89,227,83,132,95,10,0};  // false
//        int[] nums = {237};  // false
        boolean ret = lc.validUtf8(nums);
        System.out.println(ret);
    }

}
