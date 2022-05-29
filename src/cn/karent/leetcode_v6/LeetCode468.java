package cn.karent.leetcode_v6;

/******************************************
 * @author wan
 * @date 2022.05.29 10:08
 * @descripton 验证IP地址
 ******************************************/
public class LeetCode468 {

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".")) {
            boolean ret = validIPv4(queryIP);
            return ret ? "IPv4" : "Neither";
        } else {
            boolean ret = validIPv6(queryIP);
            return ret ? "IPv6" : "Neither";
        }
    }

    private int count(String s, char c) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) cnt++;
        }
        return cnt;
    }

    private boolean validIPv6(String ip) {
        String[] strArr = ip.split(":");
        if (count(ip, ':') != 7) return false;
        if (strArr.length != 8) return false;
        for (int i = 0; i < strArr.length; i++) {
            if (!validIPv6Char(strArr[i])) return false;
        }
        return true;
    }

    private boolean validIPv6Char(String s) {
        char[] chs = s.toCharArray();
        // 1. 字符位数超过4的不行
        if (chs.length < 1 || chs.length > 4) return false;
        // 每一位都是0-9, a-f, A-F
        for (int i = 0; i < chs.length; i++) {
            if ( !((chs[i] >= '0' && chs[i] <= '9') || (chs[i] >= 'a' && chs[i] <= 'f') ||
                    chs[i] >= 'A' && chs[i] <= 'F')) return false;
        }
        return true;
    }

    private boolean validIPv4(String ip) {
        String[] strArr = ip.split("\\.");
        if (count(ip, '.') != 3) return false;
        if (strArr.length != 4) return false;
        for (int i = 0; i < strArr.length; i++) {
            if (!validIPv4Digital(strArr[i])) return false;
        }
        return true;
    }

    private boolean validIPv4Digital(String s) {
        if ((s.length() > 1 && s.charAt(0) == '0') || s.length() == 0) return false;
        char[] chs = s.toCharArray();
        int v = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= '0' && chs[i] <= '9') {
                v = v * 10 + (chs[i] - '0');
                if (v >= 256) return false;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode468 lc = new LeetCode468();
        String ip = "172.16.254.1";
//        String ip = "2001:0db8:85a3:0000:0:8A2E:0370:733a";
//        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(lc.validIPAddress(ip));
    }

}
